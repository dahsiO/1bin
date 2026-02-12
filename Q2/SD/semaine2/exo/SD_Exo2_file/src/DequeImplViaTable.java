// implementation de l'interface Deque via une table circulaire

public class DequeImplViaTable<E> implements Deque<E> {

    private Object[] table;  // ne modifiez pas cet identifiant, la classe test l'utilise
    private int indicePremier;  // ne modifiez pas cet identifiant, la classe test l'utilise
    private int taille;        // ne modifiez pas cet identifiant, la classe test l'utilise
    // N'ajoutez pas d'autres attributs, la classe test risquerait de ne pas fonctionner

    public DequeImplViaTable() {
        table = new Object[4];
        taille = 0;
        indicePremier = 0;
    }

    @Override
    public int taille() {
        return taille;
    }

    @Override
    public boolean estVide() {
        return taille == 0;
    }

    @Override
    public E premier() throws DequeVideException {
        if (taille == 0)
            throw new DequeVideException();
        return (E) table[indicePremier];
    }

    @Override
    public E retirerPremier() throws DequeVideException {
        if (taille == 0)
            throw new FileVideException();
        Object element = table[indicePremier];
        indicePremier = (indicePremier + 1) % table.length;
        taille--;
        return (E) element;
    }

    @Override
    public void ajouterEnDernier(E element) {
        if (taille == table.length) {
            Object[] tableTemp = new Object[table.length * 2];

            int iTemp = 0;
            for (int i = indicePremier; i < table.length; i++) {
                tableTemp[iTemp] = table[i];
                iTemp++;
            }
            for (int i = 0; i < indicePremier; i++) {
                tableTemp[iTemp] = table[i];
                iTemp++;
            }
            table = tableTemp;
            indicePremier = 0;
        }
        table[(indicePremier + taille) % table.length] = element;
        taille++;
    }

    @Override
    public E dernier() throws DequeVideException {
        //TODO
        return null;
    }

    @Override
    public E retirerDernier() throws DequeVideException {
        //TODO
        return null;
    }

    @Override
    public void ajouterEnPremier(E element) {
        //TODO

    }

}
