import { Patient, PatientDTO, PatientShortDTO } from "../models/patient.model";

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
}