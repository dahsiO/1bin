document.getElementById('doctorForm').addEventListener('submit', function(event) {
  event.preventDefault();
  const doctorId = document.getElementById('doctorId').value;
  fetch(`http://localhost:3000/doctors/${doctorId}`)
      .then(response => {
          if (!response.ok) {
              throw new Error('Doctor not found');
          }
          return response.json();
      })
      .then(data => {
          document.getElementById('lastName').textContent = data.lastName;
          document.getElementById('firstName').textContent = data.firstName;
          document.getElementById('id').textContent = data.id;
          document.getElementById('specialty').textContent = data.speciality;
          document.getElementById('errorMessage').textContent = '';
      })
      .catch(error => {
          document.getElementById('lastName').textContent = '';
          document.getElementById('firstName').textContent = '';
          document.getElementById('id').textContent = '';
          document.getElementById('specialty').textContent = '';
          document.getElementById('errorMessage').textContent = 'NOT FOUND';
      });
});
