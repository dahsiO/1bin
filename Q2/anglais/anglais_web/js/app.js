'use strict';

// ── State ─────────────────────────────────────────────────────────────────────
const state = {
  vocab: [],
  chapters: [],
  categories: [],
  currentChapter: 'all',
  currentCategory: 'all',
  currentTab: 'flashcards',
  // flashcard
  fc: { index: 0, flipped: false, shuffled: [], direction: 'en-fr' },
  // qcm
  qcm: { index: 0, shuffled: [], answered: false, score: 0, missed: [] },
  // dictee
  dt: { index: 0, shuffled: [], answered: false, score: 0, missed: [] },
  // fill in the blank
  fib: { index: 0, shuffled: [], answered: false, score: 0, missed: [] },
  // exam
  exam: {
    active: false, part: 0, timer: null, timeLeft: 0,
    versionId: null, text: null, vocabWords: [], fibExprs: [],
    answers: { tf: {}, open: {}, vocab: [], fib: [] },
    scores: { tf: 0, open: 0, vocab: 0, fib: 0, total: 0 },
    missedVocab: [], missedFib: [],
  },
  // session
  session: { correct: 0, total: 0 },
};

// ── localStorage helpers ──────────────────────────────────────────────────────
const LS_KEY = 'vocab_stats_v1';

function loadStats() {
  try { return JSON.parse(localStorage.getItem(LS_KEY)) || {}; } catch { return {}; }
}

function saveStats(stats) {
  localStorage.setItem(LS_KEY, JSON.stringify(stats));
}

function recordResult(word, correct) {
  const stats = loadStats();
  const ch = word.chapter;
  if (!stats[ch]) stats[ch] = { seen: 0, correct: 0, missed: [] };
  stats[ch].seen++;
  if (correct) {
    stats[ch].correct++;
    state.session.correct++;
  } else {
    if (!stats[ch].missed.find(m => m.id === word.id)) {
      stats[ch].missed.push({ id: word.id, en: word.en, fr: word.fr });
    }
  }
  state.session.total++;
  saveStats(stats);
  updateSessionScore();
}

function updateSessionScore() {
  document.getElementById('session-score').textContent =
    `${state.session.correct} / ${state.session.total}`;
}

// ── Utility ───────────────────────────────────────────────────────────────────
function shuffle(arr) {
  const a = [...arr];
  for (let i = a.length - 1; i > 0; i--) {
    const j = Math.floor(Math.random() * (i + 1));
    [a[i], a[j]] = [a[j], a[i]];
  }
  return a;
}

function normalize(str) {
  return str.toLowerCase()
    .normalize('NFD').replace(/[̀-ͯ]/g, '')
    .trim();
}

function filteredVocab() {
  return state.vocab.filter(w => {
    const chapterOk = state.currentChapter === 'all' || w.chapter === state.currentChapter;
    const categoryOk = state.currentCategory === 'all' || w.category === state.currentCategory;
    return chapterOk && categoryOk;
  });
}

function getDistractors(correct, pool, count = 3) {
  const others = pool.filter(w => w.id !== correct.id);
  const picked = shuffle(others).slice(0, count);
  // fill globally if not enough
  if (picked.length < count) {
    const global = state.vocab.filter(w => w.id !== correct.id && !picked.find(p => p.id === w.id));
    const extra = shuffle(global).slice(0, count - picked.length);
    picked.push(...extra);
  }
  return picked.slice(0, count);
}

// ── Rendering helpers ─────────────────────────────────────────────────────────
function el(tag, attrs = {}, ...children) {
  const e = document.createElement(tag);
  for (const [k, v] of Object.entries(attrs)) {
    if (k === 'class') e.className = v;
    else if (k.startsWith('on')) e.addEventListener(k.slice(2), v);
    else e.setAttribute(k, v);
  }
  for (const child of children) {
    if (child == null) continue;
    e.appendChild(typeof child === 'string' ? document.createTextNode(child) : child);
  }
  return e;
}

function progressBar(current, total) {
  const pct = total ? Math.round((current / total) * 100) : 0;
  return el('div', { class: 'progress-bar-wrap' },
    el('div', { class: 'progress-label' }, `${current} / ${total}`),
    el('div', { class: 'progress-bar-track' },
      el('div', { class: 'progress-bar-fill', style: `width:${pct}%` })
    )
  );
}

// ── Sidebar ───────────────────────────────────────────────────────────────────
function renderSidebar() {
  const sidebar = document.getElementById('sidebar');
  sidebar.innerHTML = '';

  // ── Chapitres ──
  sidebar.appendChild(el('h2', {}, 'Chapitres'));

  const allChCount = state.currentCategory === 'all'
    ? state.vocab.length
    : state.vocab.filter(w => w.category === state.currentCategory).length;

  sidebar.appendChild(el('button', {
    class: 'chapter-btn' + (state.currentChapter === 'all' ? ' active' : ''),
    onclick: () => selectChapter('all'),
  }, '📚 Tous les chapitres',
    el('span', { class: 'chapter-count' }, String(allChCount))
  ));

  for (const ch of state.chapters) {
    const count = state.vocab.filter(w =>
      w.chapter === ch && (state.currentCategory === 'all' || w.category === state.currentCategory)
    ).length;
    sidebar.appendChild(el('button', {
      class: 'chapter-btn' + (state.currentChapter === ch ? ' active' : ''),
      onclick: () => selectChapter(ch),
    }, ch,
      el('span', { class: 'chapter-count' }, String(count))
    ));
  }

  // ── Catégories ──
  sidebar.appendChild(el('div', { class: 'sidebar-divider' }));
  sidebar.appendChild(el('h2', {}, 'Catégories'));

  const allCatCount = state.currentChapter === 'all'
    ? state.vocab.length
    : state.vocab.filter(w => w.chapter === state.currentChapter).length;

  sidebar.appendChild(el('button', {
    class: 'chapter-btn' + (state.currentCategory === 'all' ? ' active' : ''),
    onclick: () => selectCategory('all'),
  }, '🏷 Toutes les catégories',
    el('span', { class: 'chapter-count' }, String(allCatCount))
  ));

  for (const cat of state.categories) {
    const count = state.vocab.filter(w =>
      w.category === cat && (state.currentChapter === 'all' || w.chapter === state.currentChapter)
    ).length;
    if (count === 0) continue;
    sidebar.appendChild(el('button', {
      class: 'chapter-btn' + (state.currentCategory === cat ? ' active' : ''),
      onclick: () => selectCategory(cat),
    }, cat,
      el('span', { class: 'chapter-count' }, String(count))
    ));
  }
}

function selectChapter(ch) {
  if (state.exam.active) return;
  state.currentChapter = ch;
  renderSidebar();
  resetCurrentMode();
  document.getElementById('sidebar').classList.remove('open');
  document.getElementById('sidebar-overlay').classList.remove('open');
}

function selectCategory(cat) {
  if (state.exam.active) return;
  state.currentCategory = cat;
  renderSidebar();
  resetCurrentMode();
  document.getElementById('sidebar').classList.remove('open');
  document.getElementById('sidebar-overlay').classList.remove('open');
}

// ── Tab navigation ────────────────────────────────────────────────────────────
function selectTab(tab) {
  if (state.exam.active && tab !== 'exam') return;
  state.currentTab = tab;
  document.querySelectorAll('.tab-btn').forEach(b => {
    b.classList.toggle('active', b.dataset.tab === tab);
  });
  resetCurrentMode();
}

function resetCurrentMode() {
  if (state.currentTab === 'exam') { renderExam(); return; }
  const vocab = filteredVocab();
  if (state.currentTab === 'flashcards') {
    state.fc.index = 0;
    state.fc.flipped = false;
    state.fc.shuffled = [...vocab];
    renderFlashcards();
  } else if (state.currentTab === 'qcm') {
    state.qcm.index = 0;
    state.qcm.answered = false;
    state.qcm.score = 0;
    state.qcm.missed = [];
    state.qcm.shuffled = shuffle(vocab);
    renderQCM();
  } else if (state.currentTab === 'dictee') {
    state.dt.index = 0;
    state.dt.answered = false;
    state.dt.score = 0;
    state.dt.missed = [];
    state.dt.shuffled = shuffle(vocab);
    renderDictee();
  } else if (state.currentTab === 'stats') {
    renderStats();
  } else if (state.currentTab === 'fib') {
    const fibWords = fibVocab();
    state.fib.index = 0;
    state.fib.answered = false;
    state.fib.score = 0;
    state.fib.missed = [];
    state.fib.shuffled = shuffle(fibWords);
    renderFIB();
  }
}

// ── Flashcards ────────────────────────────────────────────────────────────────
function renderFlashcards() {
  const main = document.getElementById('main');
  main.innerHTML = '';

  const vocab = state.fc.shuffled;
  if (!vocab.length) {
    main.appendChild(el('div', { class: 'empty-state' }, 'Aucun mot pour ce filtre.'));
    return;
  }

  const idx = state.fc.index;
  const word = vocab[idx];
  const dir = state.fc.direction;
  const frontWord = dir === 'en-fr' ? word.en : word.fr;
  const backWord  = dir === 'en-fr' ? word.fr : word.en;
  const frontHint = dir === 'en-fr' ? 'EN' : 'FR';
  const backHint  = dir === 'en-fr' ? 'FR' : 'EN';

  // header row
  const header = el('div', { class: 'section-header' },
    el('span', { class: 'section-title' }, 'Flashcards'),
    el('div', { class: 'direction-toggle' },
      el('button', { class: 'dir-btn' + (dir === 'en-fr' ? ' active' : ''), onclick: () => setDirection('en-fr') }, 'EN → FR'),
      el('button', { class: 'dir-btn' + (dir === 'fr-en' ? ' active' : ''), onclick: () => setDirection('fr-en') }, 'FR → EN'),
    )
  );

  const pb = progressBar(idx + 1, vocab.length);

  // card
  const cardInner = el('div', { class: 'flashcard' + (state.fc.flipped ? ' flipped' : '') });

  const front = el('div', { class: 'card-face front' },
    el('span', { class: 'card-hint' }, frontHint),
    el('div', { class: 'card-word' }, frontWord),
    el('span', { class: 'card-badge' }, word.category),
  );

  const back = el('div', { class: 'card-face back' },
    el('span', { class: 'card-hint' }, backHint),
    el('div', { class: 'card-word' }, backWord),
    el('span', { class: 'card-chapter' }, word.chapter),
  );

  cardInner.appendChild(front);
  cardInner.appendChild(back);

  const cardWrap = el('div', { class: 'flashcard-wrap', onclick: flipCard }, cardInner);
  cardWrap.setAttribute('tabindex', '0');

  // buttons
  const btnRow = el('div', { class: 'btn-row' },
    el('button', { class: 'btn', onclick: fcPrev }, '← Précédent'),
    el('button', { class: 'btn btn-primary', onclick: flipCard }, state.fc.flipped ? 'Masquer' : 'Révéler'),
    el('button', { class: 'btn', onclick: fcNext }, 'Suivant →'),
  );

  const extraRow = el('div', { class: 'btn-row', style: 'margin-top:10px' },
    el('button', { class: 'btn btn-sm', onclick: shuffleFlashcards }, '🔀 Mélanger'),
    el('button', { class: 'btn btn-sm', onclick: resetFlashcards }, '↺ Recommencer'),
  );

  main.appendChild(header);
  main.appendChild(pb);
  main.appendChild(cardWrap);
  main.appendChild(btnRow);
  main.appendChild(extraRow);
}

function flipCard() {
  state.fc.flipped = !state.fc.flipped;
  renderFlashcards();
}

function fcNext() {
  const len = state.fc.shuffled.length;
  if (!len) return;
  state.fc.index = (state.fc.index + 1) % len;
  state.fc.flipped = false;
  renderFlashcards();
}

function fcPrev() {
  const len = state.fc.shuffled.length;
  if (!len) return;
  state.fc.index = (state.fc.index - 1 + len) % len;
  state.fc.flipped = false;
  renderFlashcards();
}

function shuffleFlashcards() {
  state.fc.shuffled = shuffle(state.fc.shuffled);
  state.fc.index = 0;
  state.fc.flipped = false;
  renderFlashcards();
}

function resetFlashcards() {
  state.fc.index = 0;
  state.fc.flipped = false;
  state.fc.shuffled = [...filteredVocab()];
  renderFlashcards();
}

function setDirection(dir) {
  state.fc.direction = dir;
  state.fc.flipped = false;
  renderFlashcards();
}

// ── QCM ───────────────────────────────────────────────────────────────────────
function renderQCM() {
  const main = document.getElementById('main');
  main.innerHTML = '';

  const vocab = state.qcm.shuffled;
  if (!vocab.length) {
    main.appendChild(el('div', { class: 'empty-state' }, 'Aucun mot pour ce filtre.'));
    return;
  }

  const idx = state.qcm.index;
  if (idx >= vocab.length) {
    showQCMSummary();
    return;
  }

  const word = vocab[idx];
  const distractors = getDistractors(word, filteredVocab());
  const choices = shuffle([word, ...distractors]);

  const header = el('div', { class: 'section-header' },
    el('span', { class: 'section-title' }, 'QCM'),
    el('span', {}, `Score : ${state.qcm.score} / ${idx}`)
  );

  const pb = progressBar(idx + 1, vocab.length);

  const questionCard = el('div', { class: 'qcm-question' },
    el('div', { class: 'qcm-word' }, word.en),
    el('div', { class: 'qcm-meta' }, `${word.category} — ${word.chapter}`)
  );

  const choicesWrap = el('div', { class: 'qcm-choices' });

  const btnRow = el('div', { class: 'btn-row' });

  const nextBtn = el('button', {
    class: 'btn btn-primary',
    style: 'display:none',
    onclick: () => { state.qcm.index++; state.qcm.answered = false; renderQCM(); }
  }, idx + 1 >= vocab.length ? 'Voir le résumé →' : 'Question suivante →');

  for (const choice of choices) {
    const btn = el('button', {
      class: 'choice-btn',
      onclick: function() {
        if (state.qcm.answered) return;
        state.qcm.answered = true;
        const correct = choice.id === word.id;
        choicesWrap.querySelectorAll('.choice-btn').forEach(b => b.disabled = true);
        btn.classList.add(correct ? 'correct' : 'wrong');
        if (!correct) {
          choicesWrap.querySelectorAll('.choice-btn').forEach(b => {
            if (b.textContent === word.fr) b.classList.add('correct');
          });
          state.qcm.missed.push(word);
        } else {
          state.qcm.score++;
        }
        recordResult(word, correct);
        nextBtn.style.display = '';
        btnRow.appendChild(nextBtn);
      }
    }, choice.fr);
    choicesWrap.appendChild(btn);
  }

  main.appendChild(header);
  main.appendChild(pb);
  main.appendChild(questionCard);
  main.appendChild(choicesWrap);
  main.appendChild(btnRow);
}

function showQCMSummary() {
  const vocab = state.qcm.shuffled;
  const score = state.qcm.score;
  const total = vocab.length;
  const pct = total ? Math.round((score / total) * 100) : 0;

  const missedItems = state.qcm.missed.map(w =>
    el('li', {},
      el('span', { class: 'missed-en' }, w.en),
      el('span', { class: 'missed-fr' }, w.fr)
    )
  );

  const overlay = el('div', { class: 'summary-overlay' },
    el('div', { class: 'summary-box' },
      el('h2', {}, '🎉 Résumé QCM'),
      el('div', { class: 'summary-score' }, `${pct}%`),
      el('div', { class: 'summary-sub' }, `${score} bonne${score > 1 ? 's' : ''} réponse${score > 1 ? 's' : ''} sur ${total}`),
      missedItems.length
        ? el('div', {},
            el('p', { style: 'font-size:0.85rem;font-weight:600;margin-bottom:8px' }, `Mots ratés (${missedItems.length}) :`),
            el('ul', { class: 'missed-list' }, ...missedItems)
          )
        : el('p', { style: 'color:var(--green);font-weight:600' }, '✓ Parfait score !'),
      el('div', { class: 'btn-row', style: 'margin-top:16px' },
        el('button', { class: 'btn btn-primary', onclick: () => { overlay.remove(); resetCurrentMode(); } }, 'Rejouer'),
        el('button', { class: 'btn', onclick: () => overlay.remove() }, 'Fermer'),
      )
    )
  );
  document.body.appendChild(overlay);
}

// ── Dictée ────────────────────────────────────────────────────────────────────
function renderDictee() {
  const main = document.getElementById('main');
  main.innerHTML = '';

  const vocab = state.dt.shuffled;
  if (!vocab.length) {
    main.appendChild(el('div', { class: 'empty-state' }, 'Aucun mot pour ce filtre.'));
    return;
  }

  const idx = state.dt.index;
  if (idx >= vocab.length) {
    showDicteeSummary();
    return;
  }

  const word = vocab[idx];
  let answered = false;

  const header = el('div', { class: 'section-header' },
    el('span', { class: 'section-title' }, 'Dictée'),
    el('span', {}, `Score : ${state.dt.score} / ${idx}`)
  );

  const pb = progressBar(idx + 1, vocab.length);

  const input = el('input', {
    type: 'text',
    class: 'dictee-input',
    placeholder: 'Tapez la traduction française…',
    autocomplete: 'off',
    autocorrect: 'off',
    spellcheck: 'false',
  });

  const validateBtn = el('button', { class: 'btn btn-primary', onclick: validate }, 'Valider');

  const feedback = el('div', {});

  const nextBtn = el('button', {
    class: 'btn btn-primary',
    style: 'display:none',
    onclick: () => { state.dt.index++; state.dt.answered = false; renderDictee(); }
  }, idx + 1 >= vocab.length ? 'Voir le résumé →' : 'Suivant →');

  const card = el('div', { class: 'dictee-card' },
    el('div', { class: 'card-badge' }, word.category),
    el('div', { class: 'dictee-word' }, word.en),
    el('div', { class: 'dictee-input-wrap' }, input, validateBtn),
    feedback,
    nextBtn,
  );

  function validate() {
    if (answered) return;
    const val = input.value.trim();
    if (!val) { input.focus(); return; }
    answered = true;
    input.disabled = true;
    validateBtn.disabled = true;

    const correct = normalize(val) === normalize(word.fr);
    input.classList.add(correct ? 'correct-input' : 'wrong-input');

    const msg = el('div', { class: 'feedback-msg ' + (correct ? 'correct' : 'wrong') },
      correct ? '✓ Correct !' : `✗ La bonne réponse : ${word.fr}`
    );
    feedback.appendChild(msg);

    if (correct) { state.dt.score++; }
    else { state.dt.missed.push(word); }

    recordResult(word, correct);
    nextBtn.style.display = '';
  }

  input.addEventListener('keydown', e => { if (e.key === 'Enter') validate(); });

  main.appendChild(header);
  main.appendChild(pb);
  main.appendChild(card);

  setTimeout(() => input.focus(), 50);
}

function showDicteeSummary() {
  const vocab = state.dt.shuffled;
  const score = state.dt.score;
  const total = vocab.length;
  const pct = total ? Math.round((score / total) * 100) : 0;

  const missedItems = state.dt.missed.map(w =>
    el('li', {},
      el('span', { class: 'missed-en' }, w.en),
      el('span', { class: 'missed-fr' }, w.fr)
    )
  );

  const overlay = el('div', { class: 'summary-overlay' },
    el('div', { class: 'summary-box' },
      el('h2', {}, '🎉 Résumé Dictée'),
      el('div', { class: 'summary-score' }, `${pct}%`),
      el('div', { class: 'summary-sub' }, `${score} bonne${score > 1 ? 's' : ''} sur ${total}`),
      missedItems.length
        ? el('div', {},
            el('p', { style: 'font-size:0.85rem;font-weight:600;margin-bottom:8px' }, `Mots ratés (${missedItems.length}) :`),
            el('ul', { class: 'missed-list' }, ...missedItems)
          )
        : el('p', { style: 'color:var(--green);font-weight:600' }, '✓ Parfait score !'),
      el('div', { class: 'btn-row', style: 'margin-top:16px' },
        el('button', { class: 'btn btn-primary', onclick: () => { overlay.remove(); resetCurrentMode(); } }, 'Rejouer'),
        el('button', { class: 'btn', onclick: () => overlay.remove() }, 'Fermer'),
      )
    )
  );
  document.body.appendChild(overlay);
}

// ── Stats ─────────────────────────────────────────────────────────────────────
function renderStats() {
  const main = document.getElementById('main');
  main.innerHTML = '';

  const stats = loadStats();
  let totalSeen = 0, totalCorrect = 0;
  for (const ch of Object.values(stats)) {
    totalSeen += ch.seen || 0;
    totalCorrect += ch.correct || 0;
  }
  const globalRate = totalSeen ? Math.round((totalCorrect / totalSeen) * 100) : 0;

  const header = el('div', { class: 'section-header' },
    el('span', { class: 'section-title' }, 'Statistiques'),
    el('button', { class: 'btn btn-sm', onclick: resetStats }, '🗑 Réinitialiser'),
  );

  const grid = el('div', { class: 'stats-grid' },
    el('div', { class: 'stat-card' },
      el('div', { class: 'stat-number' }, String(totalSeen)),
      el('div', { class: 'stat-label' }, 'Mots vus')
    ),
    el('div', { class: 'stat-card' },
      el('div', { class: 'stat-number' }, String(totalCorrect)),
      el('div', { class: 'stat-label' }, 'Bonnes réponses')
    ),
    el('div', { class: 'stat-card' },
      el('div', { class: 'stat-number' }, `${globalRate}%`),
      el('div', { class: 'stat-label' }, 'Taux global')
    ),
    el('div', { class: 'stat-card' },
      el('div', { class: 'stat-number' }, String(state.vocab.length)),
      el('div', { class: 'stat-label' }, 'Total mots')
    ),
  );

  // per-chapter table
  const rows = state.chapters.map(ch => {
    const s = stats[ch] || { seen: 0, correct: 0, missed: [] };
    const rate = s.seen ? Math.round((s.correct / s.seen) * 100) : 0;
    return el('tr', {},
      el('td', {}, ch),
      el('td', { style: 'text-align:center' }, String(s.seen)),
      el('td', {},
        el('div', { class: 'rate-bar' },
          el('div', { class: 'rate-track' },
            el('div', { class: 'rate-fill', style: `width:${rate}%` })
          ),
          el('span', { style: 'font-size:0.78rem;width:36px;text-align:right' }, `${rate}%`)
        )
      )
    );
  });

  const table = el('div', { class: 'chapter-stats-table' },
    el('table', {},
      el('thead', {},
        el('tr', {},
          el('th', {}, 'Chapitre'),
          el('th', { style: 'text-align:center' }, 'Vus'),
          el('th', {}, 'Réussite'),
        )
      ),
      el('tbody', {}, ...rows)
    )
  );

  main.appendChild(header);
  main.appendChild(grid);
  main.appendChild(table);
}

function resetStats() {
  if (!confirm('Réinitialiser toutes les statistiques ?')) return;
  localStorage.removeItem(LS_KEY);
  state.session.correct = 0;
  state.session.total = 0;
  updateSessionScore();
  renderStats();
}

// ── Fill in the Blank — data ──────────────────────────────────────────────────
const FIB_CATEGORIES = ['Idiomatic expressions', 'Expressions worth remembering!', 'Idioms'];
const EXAM_DURATION_MINUTES = 45;

const sentenceTemplates = {
  'Back to the drawing board': 'The prototype failed, so the team went ___ and started fresh.',
  'The ball is in your court': 'We submitted our proposal; now ___ to accept or reject it.',
  'Up and running': 'After the maintenance window, the system was finally ___ by 6 AM.',
  'A piece of cake': 'Once you understand recursion, binary trees are ___.',
  'In the same boat': 'All the developers were ___ when the deadline was moved up.',
  'Bite the bullet': 'They had to ___ and rewrite the entire legacy codebase.',
  'Cutting corners': '___ on security checks led directly to the data breach.',
  'Burn the midnight oil': 'She had to ___ to finish her project before the deadline.',
  'To throw in the towel': 'After three failed builds, some engineers wanted ___, but the team persisted.',
  'To hit the nail on the head': 'The tester really ___ when she identified the root cause of the bug.',
  'In the pipeline': 'A new version of the software is ___ and will be released next quarter.',
  'Hit the wall': 'The development team ___ when the server ran out of memory mid-deployment.',
  'The nuts and bolts': 'Before writing any code, you need to understand ___ of how the OS works.',
  'Pull the plug': 'Management decided to ___ on the project after budget cuts.',
  'To cut corners': 'The team was warned not ___ when testing the new payment system.',
  'A blessing in disguise': 'The server outage was ___ — it revealed a critical vulnerability.',
  'To bite the bullet': 'We had to ___ and migrate the entire database over the weekend.',
  'To break the ice': 'The new intern tried to ___ by sharing a funny debugging story.',
  'To go back to the drawing board': 'After user testing failed, we had ___ with the entire UI design.',
  'Cut corners': 'They chose to ___ on encryption, which proved to be a costly mistake.',
  'Bug in the systems': 'There was a serious ___ that caused all users to be logged out unexpectedly.',
  'Hold the fort': 'While the lead developer was on leave, the junior team had to ___ alone.',
  'Crash and burn': 'Without proper testing, the app will ___ on its first public release.',
  'Behind the scenes': 'A lot of work happens ___ before a website ever goes live.',
  'A lightbulb moment': 'It was ___ when she realised the issue was caused by integer overflow.',
  'A game-changer': 'The introduction of cloud computing was truly ___ for the software industry.',
  'Think outside the box': 'To solve this legacy code problem, you really need to ___.',
  "The sky's the limit": 'With modern AI tools available today, ___ for what developers can build.',
  'Break the mold': 'The startup tried to ___ with a completely serverless architecture.',
  'Cover all your bases': 'Before launching, make sure to ___ — test on every major browser.',
  'A double-edged sword': 'Open-source software is ___ — it\'s free but comes with security risks.',
  "Dot the i's and cross the t's": 'Before filing the patent, the legal team had to ___ meticulously.',
  'Behind closed doors': 'Most of the licensing negotiations were handled ___ between the two firms.',
  'Keep something under wraps': 'The new feature was ___ until the official launch event.',
  'Off the record': 'The engineer admitted, ___, that the system had known vulnerabilities.',
  'A grey area': 'Whether scraping public data is legal remains ___.',
  'Go the extra mile': 'Our support team always ___ to resolve customer issues quickly.',
  'Well-oiled machine': 'After months of optimisation, the CI/CD pipeline ran like ___.',
  'In full swing': 'By midday the hackathon was ___, with every team coding furiously.',
  'The brain of the operation': 'The lead architect was truly ___ behind the entire microservices redesign.',
  'Go off track': 'The sprint started to ___ once the requirements kept changing mid-week.',
  'A glitch in the system': 'There was ___ that caused duplicate entries in the database.',
  'Push the envelope': 'The robotics team decided to ___ by adding voice recognition to their bot.',
  'Get the ball rolling': "Let's ___ by setting up the repo and creating the first sprint board.",
  'At the cutting edge': 'This research lab is ___ of machine learning development.',
  'On the same wavelength': 'Before the project kicked off, the team needed to make sure they were ___.',
  'Caught red-handed': 'The hacker was ___ trying to access the company\'s private database.',
  'Spill the beans': "Don't ___ about the surprise update — it hasn't been announced yet.",
  'Hit the nail on the head': 'The reviewer really ___ when she spotted the off-by-one error.',
  'Bite off more than you can chew': "Don't ___ by promising a full redesign in just two weeks.",
  'Barking up the wrong tree': 'If you think the bug is in the frontend, you\'re ___ — check the API.',
  'Jump on the bandwagon': 'Every startup seemed to ___ when blockchain became trendy.',
  'Let the cat out of the bag': 'One employee accidentally ___ about the upcoming merger.',
  'Under the weather': 'The lead developer was ___ and couldn\'t attend the sprint review.',
  'Pull someone\'s leg': 'He was just ___ when he said the deployment would take five minutes.',
  'A game changer': 'Containerisation with Docker was ___ for modern deployment workflows.',
  'Break the ice': 'The team lead shared a joke to ___ at the start of the retrospective.',
  'Throw in the towel': 'After two years without funding, the founders finally had to ___.',
  'Call it a day': 'After fixing the critical bug, the exhausted team decided to ___ and go home.',
};

function getSentence(word) {
  return sentenceTemplates[word.en] || `Use this expression in the right context: ___.`;
}

const EXAM_VERSIONS = [
  {
    id: 1,
    title: 'IT vs Computer Science',
    text: `IT careers focus on installing and maintaining computer systems, while computer science uses mathematics to program systems more efficiently. IT professionals usually work in teams within organizations, while computer scientists may work as freelancers or in research. Both fields are growing rapidly, with IT roles expected to increase by up to 37% by 2026. Skills essential for IT include Linux, SQL, and project management, while computer scientists also need Java and software engineering knowledge.`,
    questions: [
      { type: 'open', q: 'What is the main difference between IT and computer science?', expected: 'IT focuses on maintaining/installing systems; CS focuses on programming and mathematics' },
      { type: 'open', q: 'What skills are required specifically for computer science (not IT)?', expected: 'Java, software engineering, systems engineer skills' },
      { type: 'tf', q: 'IT professionals always work alone.', answer: false },
      { type: 'tf', q: 'Both IT and CS fields are growing rapidly.', answer: true },
    ],
  },
  {
    id: 2,
    title: 'Social Media & Attention',
    text: `Social media platforms are designed to capture and hold our attention for as long as possible. Notifications, likes, and infinite scrolling trigger dopamine releases in the brain, making these platforms highly addictive. Studies show that constant task-switching between apps reduces productivity by up to 40%. The average person checks their phone 96 times a day. However, social media also has benefits: it strengthens social bonds, allows people to stay informed, and creates new career opportunities in digital marketing and content creation.`,
    questions: [
      { type: 'open', q: 'Why are social media platforms considered addictive?', expected: 'They trigger dopamine releases through notifications, likes, and infinite scrolling' },
      { type: 'open', q: 'What is one negative and one positive effect of social media mentioned in the text?', expected: 'Negative = reduces productivity / Positive = strengthens social bonds, career opportunities, staying informed' },
      { type: 'tf', q: 'Checking your phone frequently improves your productivity.', answer: false },
      { type: 'tf', q: 'Social media can create new job opportunities.', answer: true },
    ],
  },
  {
    id: 3,
    title: 'The Rise of Robotics',
    text: `Robotics is transforming industries at an unprecedented pace. From autonomous vehicles to surgical robots, machines are taking over tasks that were once exclusively performed by humans. In manufacturing, robots increase precision and reduce costs, but also raise concerns about job displacement. In healthcare, robotic assistants help surgeons perform complex operations with greater accuracy. Scientists are now working on humanoid robots capable of navigating human environments and performing daily routines, raising important ethical questions about the future relationship between humans and machines.`,
    questions: [
      { type: 'open', q: 'What are two industries where robotics is having a major impact?', expected: 'Manufacturing and healthcare (also acceptable: transportation / autonomous vehicles)' },
      { type: 'open', q: 'What ethical concern is raised at the end of the text?', expected: 'The future relationship between humans and machines / job displacement' },
      { type: 'tf', q: 'Robots in healthcare replace surgeons entirely.', answer: false },
      { type: 'tf', q: 'Humanoid robots are being designed to work in human environments.', answer: true },
    ],
  },
];

// ── Fill in the Blank helpers ─────────────────────────────────────────────────
function fibVocab() {
  const base = filteredVocab().filter(w => FIB_CATEGORIES.includes(w.category));
  if (base.length) return base;
  return state.vocab.filter(w => FIB_CATEGORIES.includes(w.category));
}

function normalizeFIB(str) {
  return str.toLowerCase()
    .replace(/[''`‘’]/g, "'")
    .normalize('NFD').replace(/[̀-ͯ]/g, '')
    .replace(/\s+/g, ' ')
    .trim();
}

// ── Fill in the Blank mode ────────────────────────────────────────────────────
function renderFIB() {
  const main = document.getElementById('main');
  main.innerHTML = '';

  const vocab = state.fib.shuffled;
  if (!vocab.length) {
    main.appendChild(el('div', { class: 'empty-state' },
      "No idiomatic expressions in this chapter. Select 'All chapters'."
    ));
    return;
  }

  const idx = state.fib.index;
  if (idx >= vocab.length) { showFIBSummary(); return; }

  const word = vocab[idx];
  const sentence = getSentence(word);

  const header = el('div', { class: 'section-header' },
    el('span', { class: 'section-title' }, 'Fill in the Blank'),
    el('span', {}, `Score : ${state.fib.score} / ${idx}`)
  );

  const pb = progressBar(idx + 1, vocab.length);

  let hintVisible = false;
  const hintText = el('div', { class: 'fib-hint-text', style: 'display:none' }, `🇫🇷 ${word.fr}`);
  const hintToggle = el('span', { class: 'fib-hint-toggle',
    onclick: () => {
      hintVisible = !hintVisible;
      hintText.style.display = hintVisible ? '' : 'none';
      hintToggle.textContent = hintVisible ? '👁 Masquer l\'indice' : '💡 Voir l\'indice (traduction)';
    }
  }, '💡 Voir l\'indice (traduction)');

  let answered = false;
  const input = el('input', {
    type: 'text', class: 'fib-input',
    placeholder: 'Type the expression in English…',
    autocomplete: 'off', autocorrect: 'off', spellcheck: 'false',
  });

  const validateBtn = el('button', { class: 'btn btn-primary', onclick: validate }, 'Vérifier');
  const feedback = el('div', {});
  const nextBtn = el('button', {
    class: 'btn btn-primary', style: 'display:none',
    onclick: () => { state.fib.index++; state.fib.answered = false; renderFIB(); }
  }, idx + 1 >= vocab.length ? 'Voir le résumé →' : 'Suivant →');

  const card = el('div', { class: 'fib-sentence-card' },
    el('div', { class: 'card-badge', style: 'margin-bottom:12px' }, word.category),
    el('div', { class: 'fib-sentence' }, sentence.replace('___', '___')),
    hintToggle,
    hintText,
    el('div', { class: 'fib-input-wrap' }, input, validateBtn),
    feedback,
    nextBtn,
  );

  function validate() {
    if (answered) return;
    const val = input.value.trim();
    if (!val) { input.focus(); return; }
    answered = true;
    input.disabled = true;
    validateBtn.disabled = true;
    const correct = normalizeFIB(val) === normalizeFIB(word.en);
    input.classList.add(correct ? 'correct-input' : 'wrong-input');
    feedback.appendChild(el('div', { class: 'feedback-msg ' + (correct ? 'correct' : 'wrong') },
      correct ? '✓ Correct !' : `✗ Réponse : ${word.en}`
    ));
    if (correct) { state.fib.score++; } else { state.fib.missed.push(word); }
    recordResult(word, correct);
    nextBtn.style.display = '';
  }

  input.addEventListener('keydown', e => { if (e.key === 'Enter') validate(); });

  main.appendChild(header);
  main.appendChild(pb);
  main.appendChild(card);
  setTimeout(() => input.focus(), 50);
}

function showFIBSummary() {
  const total = state.fib.shuffled.length;
  const score = state.fib.score;
  const pct = total ? Math.round((score / total) * 100) : 0;
  const missedItems = state.fib.missed.map(w =>
    el('li', {}, el('span', { class: 'missed-en' }, w.en), el('span', { class: 'missed-fr' }, w.fr))
  );
  const overlay = el('div', { class: 'summary-overlay' },
    el('div', { class: 'summary-box' },
      el('h2', {}, '🎉 Résumé Fill in the Blank'),
      el('div', { class: 'summary-score' }, `${pct}%`),
      el('div', { class: 'summary-sub' }, `${score} correct sur ${total}`),
      missedItems.length
        ? el('div', {}, el('p', { style: 'font-size:.85rem;font-weight:600;margin-bottom:8px' }, `Expressions ratées (${missedItems.length}) :`),
            el('ul', { class: 'missed-list' }, ...missedItems))
        : el('p', { style: 'color:var(--green);font-weight:600' }, '✓ Parfait score !'),
      el('div', { class: 'btn-row', style: 'margin-top:16px' },
        el('button', { class: 'btn btn-primary', onclick: () => { overlay.remove(); resetCurrentMode(); } }, 'Rejouer'),
        el('button', { class: 'btn', onclick: () => overlay.remove() }, 'Fermer'),
      )
    )
  );
  document.body.appendChild(overlay);
}

// ── Exam mode ─────────────────────────────────────────────────────────────────
function startExam(versionId) {
  const termVocab = state.vocab.filter(w => ['Terminology', 'Vocabulary'].includes(w.category));
  const fibPool   = state.vocab.filter(w => FIB_CATEGORIES.includes(w.category));
  state.exam.versionId  = versionId;
  state.exam.text       = EXAM_VERSIONS.find(v => v.id === versionId);
  state.exam.vocabWords = shuffle(termVocab).slice(0, 8);
  state.exam.fibExprs   = shuffle(fibPool).slice(0, 8);
  state.exam.part       = 0;
  state.exam.answers    = { tf: {}, open: {}, vocab: new Array(8).fill(''), fib: new Array(8).fill('') };
  state.exam.scores     = { tf: 0, open: 0, vocab: 0, fib: 0, total: 0 };
  state.exam.missedVocab = [];
  state.exam.missedFib   = [];
  state.exam.active      = true;
  state.exam.timeLeft    = EXAM_DURATION_MINUTES * 60;
  state.currentTab = 'exam';
  document.querySelectorAll('.tab-btn').forEach(b => b.classList.toggle('active', b.dataset.tab === 'exam'));

  // lock sidebar + tabs
  document.getElementById('sidebar').style.pointerEvents = 'none';
  document.getElementById('sidebar').style.opacity = '0.4';

  const timerEl = document.getElementById('exam-timer');
  timerEl.style.display = '';
  updateTimerDisplay();

  clearInterval(state.exam.timer);
  state.exam.timer = setInterval(() => {
    state.exam.timeLeft--;
    updateTimerDisplay();
    if (state.exam.timeLeft <= 0) { clearInterval(state.exam.timer); submitExam(); }
  }, 1000);

  renderExam();
}

function updateTimerDisplay() {
  const t = state.exam.timeLeft;
  const m = String(Math.floor(t / 60)).padStart(2, '0');
  const s = String(t % 60).padStart(2, '0');
  const el2 = document.getElementById('exam-timer');
  el2.textContent = `${m}:${s}`;
  el2.classList.toggle('urgent', t <= 300);
}

function stopExam() {
  clearInterval(state.exam.timer);
  state.exam.active = false;
  document.getElementById('exam-timer').style.display = 'none';
  document.getElementById('sidebar').style.pointerEvents = '';
  document.getElementById('sidebar').style.opacity = '';
}

function submitExam() {
  stopExam();
  const ex = state.exam;

  // Score TF (0.5 each = 1 pt for 2)
  let tfScore = 0;
  ex.text.questions.filter(q => q.type === 'tf').forEach((q, i) => {
    if (ex.answers.tf[i] === q.answer) tfScore += 0.5;
  });
  ex.scores.tf = tfScore;

  // Vocab score
  let vocabScore = 0;
  ex.vocabWords.forEach((w, i) => {
    const correct = normalize(ex.answers.vocab[i] || '') === normalize(w.fr);
    if (correct) { vocabScore++; } else { ex.missedVocab.push(w); }
  });
  ex.scores.vocab = vocabScore;

  // FIB score
  let fibScore = 0;
  ex.fibExprs.forEach((w, i) => {
    const correct = normalizeFIB(ex.answers.fib[i] || '') === normalizeFIB(w.en);
    if (correct) { fibScore++; } else { ex.missedFib.push(w); }
  });
  ex.scores.fib = fibScore;

  const totalScore = ex.scores.tf + vocabScore + fibScore;
  ex.scores.total = totalScore;
  if (ex.versionId) {
    localStorage.setItem('examScore_v' + ex.versionId, totalScore.toFixed(1));
  }

  ex.part = 3;
  renderExam();
}

function renderExamSelection(main) {
  main.appendChild(el('div', { class: 'section-header', style: 'max-width:700px' },
    el('span', { class: 'section-title' }, '📝 Choisir une version'),
    el('span', { style: 'font-size:.82rem;color:var(--text-muted)' },
      `${EXAM_DURATION_MINUTES} min · Reading 4 pts · Vocab 8 pts · FIB 8 pts`)
  ));

  const grid = el('div', { class: 'exam-version-grid' });
  EXAM_VERSIONS.forEach(v => {
    const raw = localStorage.getItem('examScore_v' + v.id);
    const scoreStr = raw !== null ? `${raw} / 20` : '—';
    const hasScore = raw !== null;

    const card = el('div', { class: 'exam-version-card' },
      el('div', { class: 'exam-version-num' }, `Version ${v.id}`),
      el('div', { class: 'exam-version-title' }, v.title),
      el('div', { class: 'exam-version-score' + (hasScore ? ' has-score' : '') },
        hasScore ? `Dernier score : ${scoreStr}` : 'Pas encore passé'
      ),
      el('button', {
        class: 'btn btn-primary',
        style: 'width:100%;margin-top:12px',
        onclick: () => startExam(v.id),
      }, '🚀 Commencer')
    );
    grid.appendChild(card);
  });
  main.appendChild(grid);
}

function renderExam() {
  const main = document.getElementById('main');
  main.innerHTML = '';

  if (!state.exam.active && state.exam.part !== 3) {
    renderExamSelection(main);
    return;
  }

  const vLabel = state.exam.text ? `Version ${state.exam.versionId} — ${state.exam.text.title}` : '';
  main.appendChild(el('div', { style: 'font-size:.78rem;font-weight:600;color:var(--accent);margin-bottom:8px;width:100%;max-width:640px' }, vLabel));

  const steps = ['Reading', 'Vocabulaire', 'Fill in the Blank', 'Résultats'];
  const stepsEl = el('div', { class: 'exam-steps' });
  steps.forEach((s, i) => {
    if (i > 0) stepsEl.appendChild(el('span', { class: 'exam-step-arrow' }, '›'));
    const cls = i < state.exam.part ? 'done' : i === state.exam.part ? 'active' : '';
    stepsEl.appendChild(el('span', { class: 'exam-step ' + cls }, s));
  });
  main.appendChild(stepsEl);

  if (state.exam.part === 0) renderExamPart1(main);
  else if (state.exam.part === 1) renderExamPart2(main);
  else if (state.exam.part === 2) renderExamPart3(main);
  else renderExamResults(main);
}

function renderExamPart1(main) {
  const ex = state.exam;
  const qs = ex.text.questions;

  const block = el('div', { class: 'exam-block' });
  block.appendChild(el('h3', {}, '📖 Partie 1 — Reading Comprehension (4 pts)'));
  block.appendChild(el('div', { class: 'exam-text' }, ex.text.text));

  let tfIdx = 0, openIdx = 0;
  qs.forEach((q) => {
    const wrap = el('div', { class: 'exam-q' });
    if (q.type === 'open') {
      const idx = openIdx++;
      wrap.appendChild(el('label', {}, `Q${idx + 1}. ${q.q}`));
      const inp = el('input', { type: 'text', placeholder: 'Votre réponse…' });
      inp.value = ex.answers.open[idx] || '';
      inp.addEventListener('input', () => { ex.answers.open[idx] = inp.value; });
      wrap.appendChild(inp);
    } else {
      const idx = tfIdx++;
      wrap.appendChild(el('label', {}, `Q${openIdx + idx + 1}. ${q.q}`));
      const trueBtn = el('button', { class: 'tf-btn', onclick: () => {
        ex.answers.tf[idx] = true; trueBtn.classList.add('selected-true'); falseBtn.classList.remove('selected-false');
      }}, 'True');
      const falseBtn = el('button', { class: 'tf-btn', onclick: () => {
        ex.answers.tf[idx] = false; falseBtn.classList.add('selected-false'); trueBtn.classList.remove('selected-true');
      }}, 'False');
      if (ex.answers.tf[idx] === true) trueBtn.className += ' selected-true';
      if (ex.answers.tf[idx] === false) falseBtn.className += ' selected-false';
      wrap.appendChild(el('div', { class: 'tf-btns' }, trueBtn, falseBtn));
    }
    block.appendChild(wrap);
  });

  main.appendChild(block);
  main.appendChild(el('div', { class: 'btn-row' },
    el('button', { class: 'btn btn-primary', onclick: () => { ex.part = 1; renderExam(); } }, 'Partie suivante →')
  ));
}

function renderExamPart2(main) {
  const ex = state.exam;
  const block = el('div', { class: 'exam-block' });
  block.appendChild(el('h3', {}, '📝 Partie 2 — Vocabulaire (8 pts)'));
  block.appendChild(el('p', { style: 'font-size:.82rem;color:var(--text-muted);margin-bottom:16px' },
    'Tapez la traduction française de chaque mot anglais.'));

  ex.vocabWords.forEach((w, i) => {
    const row = el('div', { class: 'exam-word-row' });
    row.appendChild(el('span', { class: 'exam-word-en' }, w.en));
    const inp = el('input', { type: 'text', placeholder: 'Traduction…' });
    inp.value = ex.answers.vocab[i] || '';
    inp.addEventListener('input', () => { ex.answers.vocab[i] = inp.value; });
    row.appendChild(inp);
    block.appendChild(row);
  });

  main.appendChild(block);
  main.appendChild(el('div', { class: 'btn-row' },
    el('button', { class: 'btn btn-primary', onclick: () => { ex.part = 2; renderExam(); } }, 'Partie suivante →')
  ));
}

function renderExamPart3(main) {
  const ex = state.exam;
  const block = el('div', { class: 'exam-block' });
  block.appendChild(el('h3', {}, '✏️ Partie 3 — Fill in the Blank (8 pts)'));
  block.appendChild(el('p', { style: 'font-size:.82rem;color:var(--text-muted);margin-bottom:16px' },
    'Complétez chaque phrase avec la bonne expression anglaise.'));

  ex.fibExprs.forEach((w, i) => {
    const row = el('div', { class: 'exam-fib-row' });
    row.appendChild(el('div', { class: 'exam-fib-sentence' }, getSentence(w)));
    row.appendChild(el('div', { class: 'exam-fib-hint' }, `🇫🇷 ${w.fr}`));
    const inp = el('input', { type: 'text', placeholder: 'Expression anglaise…' });
    inp.value = ex.answers.fib[i] || '';
    inp.addEventListener('input', () => { ex.answers.fib[i] = inp.value; });
    row.appendChild(inp);
    block.appendChild(row);
  });

  main.appendChild(block);
  main.appendChild(el('div', { class: 'btn-row' },
    el('button', { class: 'btn btn-primary', onclick: submitExam }, '✅ Soumettre l\'examen')
  ));
}

function renderExamResults(main) {
  const ex = state.exam;
  const openQuestions = ex.text.questions.filter(q => q.type === 'open');
  const tfQuestions   = ex.text.questions.filter(q => q.type === 'tf');

  const totalScore = ex.scores.total;
  const maxScore = 20;
  const pct = Math.round((totalScore / maxScore) * 100);
  let mention = '📖 À réviser';
  if (totalScore >= 16) mention = '🏆 Excellent !';
  else if (totalScore >= 12) mention = '👍 Bien !';

  const block = el('div', { class: 'exam-block' });
  block.appendChild(el('h3', {}, 'Résultats'));
  block.appendChild(el('div', { class: 'exam-score-big' }, `${totalScore.toFixed(1)} / ${maxScore}`));
  block.appendChild(el('div', { class: 'exam-mention' }, mention));

  // Summary table
  const table = el('table', { class: 'exam-results-table' },
    el('thead', {}, el('tr', {},
      el('th', {}, 'Partie'), el('th', {}, 'Score'), el('th', {}, 'Max')
    )),
    el('tbody', {},
      el('tr', {}, el('td', {}, 'Reading — True/False'), el('td', {}, String(ex.scores.tf)), el('td', {}, '2')),
      el('tr', {}, el('td', {}, 'Reading — Questions ouvertes'), el('td', {}, 'À corriger manuellement'), el('td', {}, '2')),
      el('tr', {}, el('td', {}, 'Vocabulaire'), el('td', {}, String(ex.scores.vocab)), el('td', {}, '8')),
      el('tr', {}, el('td', {}, 'Fill in the Blank'), el('td', {}, String(ex.scores.fib)), el('td', {}, '8')),
    )
  );
  block.appendChild(table);

  // Open questions expected answers
  block.appendChild(el('h3', { style: 'margin-top:16px' }, '📖 Réponses attendues (questions ouvertes)'));
  openQuestions.forEach((q, i) => {
    const d = el('div', { style: 'margin-bottom:14px;font-size:.85rem' });
    d.appendChild(el('p', { style: 'font-weight:600;margin-bottom:4px' }, `Q${i + 1}. ${q.q}`));
    d.appendChild(el('p', { style: 'color:var(--text-muted)' }, `Votre réponse : "${ex.answers.open[i] || '—'}"`));
    d.appendChild(el('p', { style: 'color:var(--green)' }, `✓ Réponse attendue : ${q.expected}`));
    block.appendChild(d);
  });

  // TF corrections
  block.appendChild(el('h3', { style: 'margin-top:16px' }, '✅ Corrections True/False'));
  tfQuestions.forEach((q, i) => {
    const given = ex.answers.tf[i];
    const correct = given === q.answer;
    const d = el('div', { style: `font-size:.85rem;margin-bottom:8px;color:${correct ? 'var(--green)' : 'var(--red)'}` },
      `${correct ? '✓' : '✗'} "${q.q}" → ${q.answer ? 'True' : 'False'}${!correct ? ` (vous avez répondu : ${given === undefined ? 'sans réponse' : (given ? 'True' : 'False')})` : ''}`
    );
    block.appendChild(d);
  });

  // Missed vocab
  if (ex.missedVocab.length) {
    block.appendChild(el('h3', { style: 'margin-top:16px' }, '📚 Vocabulaire raté'));
    const ul = el('ul', { class: 'missed-list' });
    ex.missedVocab.forEach(w => ul.appendChild(
      el('li', {}, el('span', { class: 'missed-en' }, w.en), el('span', { class: 'missed-fr' }, w.fr))
    ));
    block.appendChild(ul);
  }

  // Missed FIB
  if (ex.missedFib.length) {
    block.appendChild(el('h3', { style: 'margin-top:16px' }, '✏️ Expressions ratées'));
    const ul = el('ul', { class: 'missed-list' });
    ex.missedFib.forEach(w => ul.appendChild(
      el('li', {}, el('span', { class: 'missed-en' }, w.en), el('span', { class: 'missed-fr' }, w.fr))
    ));
    block.appendChild(ul);
  }

  const versionId = ex.versionId;
  main.appendChild(block);
  main.appendChild(el('div', { class: 'btn-row' },
    el('button', { class: 'btn btn-primary', onclick: () => startExam(versionId) },
      '🔄 Recommencer cette version'),
    el('button', { class: 'btn', onclick: () => {
      state.exam.active = false;
      state.exam.part = 0;
      renderExam();
    }}, '← Choisir une autre version'),
  ));
}

// ── Keyboard shortcuts ────────────────────────────────────────────────────────
document.addEventListener('keydown', e => {
  // don't capture if user is typing in an input
  if (e.target.tagName === 'INPUT' || e.target.tagName === 'TEXTAREA') return;

  if (state.currentTab === 'flashcards') {
    if (e.key === ' ' || e.key === 'Enter') { e.preventDefault(); flipCard(); }
    if (e.key === 'ArrowRight') fcNext();
    if (e.key === 'ArrowLeft') fcPrev();
  }
});

// ── Bootstrap ─────────────────────────────────────────────────────────────────
async function init() {
  const res = await fetch('./vocabulary.json');
  const data = await res.json();

  state.vocab = data.vocabulary;
  state.chapters = data.meta.chapters;
  state.categories = data.meta.categories;
  state.fc.shuffled  = [...state.vocab];
  state.qcm.shuffled = shuffle(state.vocab);
  state.dt.shuffled  = shuffle(state.vocab);
  state.fib.shuffled = shuffle(state.vocab.filter(w => FIB_CATEGORIES.includes(w.category)));

  // Build sidebar
  renderSidebar();

  // Tab buttons
  document.querySelectorAll('.tab-btn').forEach(btn => {
    btn.addEventListener('click', () => selectTab(btn.dataset.tab));
  });

  // Mobile sidebar toggle
  const menuToggle = document.getElementById('menu-toggle');
  const sidebar = document.getElementById('sidebar');
  const overlay = document.getElementById('sidebar-overlay');
  menuToggle.addEventListener('click', () => {
    sidebar.classList.toggle('open');
    overlay.classList.toggle('open');
  });
  overlay.addEventListener('click', () => {
    sidebar.classList.remove('open');
    overlay.classList.remove('open');
  });

  // Render initial view
  renderFlashcards();
  updateSessionScore();
}

init().catch(err => {
  document.getElementById('main').innerHTML =
    `<div class="empty-state">Erreur de chargement : ${err.message}<br>Assurez-vous que vocabulary.json est à la racine et que vous utilisez un serveur HTTP.</div>`;
});
