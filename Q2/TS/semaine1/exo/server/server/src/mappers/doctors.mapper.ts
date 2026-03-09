import { Doctor, DoctorDTO } from "../models/doctor.model";

export class DoctorsMapper {

  public static toDTO(doctor: Doctor): DoctorDTO {
    return {
      id: doctor.id,
      firstName: doctor.firstName,
      lastName: doctor.lastName,
      speciality: doctor.speciality,
    };
  }
}
