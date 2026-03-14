import { NewPatientDTO, Patient, PatientDTO, PatientShortDTO } from "../models/patient.model";

export class PatientsMapper {

  public static toDTO(patient: Patient): PatientDTO {
    return {
      id: patient.id,
      firstName: patient.firstName,
      lastName: patient.lastName,
      birthDate: patient.birthDate,
      niss: patient.niss,
      address: patient.address,
      refDoctor: patient.refDoctor,
    };
  }

  public static toShortDTO(patient: Patient): PatientShortDTO {
    return {
      id: patient.id,
      firstName: patient.firstName,
      lastName: patient.lastName,
    };
  }
  //new method to create a patient fromNewDTO
  public static fromNewDTO(patientDTO: NewPatientDTO): Patient {
    return {
      id: 0, // This will be set by the database or service layer
      firstName: patientDTO.firstName,
      lastName: patientDTO.lastName,
      // Assuming birthDate is a string in the format "YYYY-MM-DD", we can convert it to a Date object
      birthDate: new Date(patientDTO.birthDate),
      niss: patientDTO.niss,
      address: patientDTO.address,
        refDoctor: patientDTO.refDoctor,
    };
  }
}