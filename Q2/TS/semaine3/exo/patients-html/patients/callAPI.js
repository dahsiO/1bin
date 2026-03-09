// utility functions
function updatePatientInformation(patient) {
  document.getElementById('lastName').value = patient.lastName;
  document.getElementById('firstName').value = patient.firstName;
  document.getElementById('id').value = patient.id;
  document.getElementById('birthdate').value = new Date(patient.birthDate).toISOString().split('T')[0];
  document.getElementById('niss').value = patient.niss;
  document.getElementById('street').value = patient.address.street;
  document.getElementById('city').value = patient.address.city;
  document.getElementById('zipCode').value = patient.address.zipCode;
  document.getElementById('number').value = patient.address.number;
  document.getElementById('country').value = patient.address.country;
  document.getElementById('refDoctor').value = patient.refDoctor;
  document.getElementById('errorMessage').textContent = '';
}
function clearPatientInformation() {
  document.getElementById('lastName').value = '';
  document.getElementById('firstName').value = '';
  document.getElementById('id').value = '';
  document.getElementById('birthdate').value = '';
  document.getElementById('niss').value = '';
  document.getElementById('street').value = '';
  document.getElementById('number').value = '';
  document.getElementById('city').value = '';
  document.getElementById('zipCode').value = '';
  document.getElementById('refDoctor').value = '';
  document.getElementById('country').value = '';
  document.getElementById('errorMessage').textContent = '';
}
function extactInformationFromForm() {
  return {
    lastName: document.getElementById('lastName').value,
    firstName: document.getElementById('firstName').value,
    id: parseInt(document.getElementById('id').value),
    birthDate: document.getElementById('birthdate').value,
    niss: document.getElementById('niss').value,
    address: {
      street: document.getElementById('street').value,
      city: document.getElementById('city').value,
      zipCode: document.getElementById('zipCode').value,
      country: document.getElementById('country').value,
      number: document.getElementById('number').value,
    },
    refDoctor: parseInt(document.getElementById('refDoctor').value),
  };
}
function clearPatientCreateForm() {
  document.getElementById('c_lastName').value = '';
  document.getElementById('c_firstName').value = '';
  document.getElementById('c_birthdate').value = '';
  document.getElementById('c_niss').value = '';
  document.getElementById('c_street').value = '';
  document.getElementById('c_number').value = '';
  document.getElementById('c_city').value = '';
  document.getElementById('c_zipCode').value = '';
  document.getElementById('c_refDoctor').value = '';
  document.getElementById('c_country').value = '';
}
function extractCreatePatientFormInformation() {
  return {
    lastName: document.getElementById('c_lastName').value,
    firstName: document.getElementById('c_firstName').value,
    birthDate: document.getElementById('c_birthdate').value,
    niss: document.getElementById('c_niss').value,
    address: {
      street: document.getElementById('c_street').value,
      city: document.getElementById('c_city').value,
      zipCode: document.getElementById('c_zipCode').value,
      country: document.getElementById('c_country').value,
      number: document.getElementById('c_number').value,
    },
    refDoctor: parseInt(document.getElementById('c_refDoctor').value),
  };
}
// clabck functions
document.getElementById('getPatientForm').addEventListener('submit', function (event) {
  event.preventDefault();
  const patientId = document.getElementById('patientId').value;
  fetch(`http://localhost:3000/patients/${patientId}`)
    .then(response => {
      if (!response.ok) {
        throw new Error('Patient not found');
      }
      return response.json();
    })
    .then(data => {
      clearPatientInformation();
      updatePatientInformation(data);
    })
    .catch(error => {
      // clearPatientInformation();
      document.getElementById('errorMessage').textContent = 'NOT FOUND';
    });
});

document.getElementById('updatePatientForm').addEventListener('submit', function (event) {
  event.preventDefault();
  const patient = extactInformationFromForm();
  console.log(patient);
  fetch(`http://localhost:3000/patients/${patient.id}`, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(patient)
  })
    .then(response => {
      console.log(response);
      if (!response.ok) {
        if (response.status === 400) {
          console.log(response);
          document.getElementById('errorMessage').textContent = 'BAD REQUEST';
        }
        if (response.status === 500) {
          document.getElementById('errorMessage').textContent = 'INTERNAL SERVER ERROR';
        }
        if (response.status === 404) {
          document.getElementById('errorMessage').textContent = 'PATIENT NOT FOUND';
        }
        throw new Error('Error creating patient');
      }
      return response.json();
    })
    .then(data => {
      updatePatientInformation(data);
      document.getElementById('errorMessage').textContent = '';
    })
    .catch(error => {
      clearPatientInformation();
      // document.getElementById('errorMessage').textContent = 'ERROR';
    });
});

document.getElementById('createPatientForm').addEventListener('submit', function (event) {
  event.preventDefault();
  const patient = extractCreatePatientFormInformation();
  console.log(patient);
  fetch('http://localhost:3000/patients/', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(patient)
  })
    .then(response => {
      if (!response.ok) {
        if (response.status === 400) {
          document.getElementById('infoCreateMessage').textContent = 'BAD REQUEST';
        }
        if (response.status === 500) {
          document.getElementById('infoCreateMessage').textContent = 'INTERNAL SERVER ERROR';
        }
        throw new Error('Error creating patient');
      } else {
        document.getElementById('infoCreateMessage').textContent = 'Patient created';
      }
      return response.json();
    })
    .then(data => {
      updatePatientInformation(data);
    })
    .catch(error => {
      clearPatientInformation();
    });
});
