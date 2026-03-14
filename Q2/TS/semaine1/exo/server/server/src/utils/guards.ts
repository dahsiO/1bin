import { Address, AddressDTO } from "../models/address.model";
// import { MedicalExamDTO } from "../models/medical-exam.model.dto";
// import { Appointment } from "../models/appointment.model";
import { DoctorDTO } from "../models/doctor.model";
import { NewDoctorDTO } from "../models/doctor.model";
import { NewPatientDTO, PatientDTO } from "../models/patient.model";
// import { NewUserDTO } from "../models/user.model";

/**
 * Function that validates that an input is a number
 * @param data any data
 * @returns true if data is a number
 */
export function isNumber(data: any): data is number {
  return data !== undefined && data !== null && typeof data === 'number' && !isNaN(data);
}

/**
 * Function that validates that an input is a string
 * @param data any data
 * @returns true if data is a string
*/
export function isString(data: any): data is string {
  return data !== undefined && data !== null && typeof data === 'string';
}

/**
 * Function that validates that an input is a valid Doctor model
 * @param data 
 * @returns true if data is a valid Doctor model
 */
export function isDoctor(data: unknown): data is DoctorDTO {
  if (
    data && typeof data === 'object' &&
    ((data as DoctorDTO).id === undefined || typeof (data as DoctorDTO).id == 'number') &&
    'firstName' in data && 'lastName' in data &&
    'speciality' in data &&
    typeof (data as DoctorDTO).firstName === 'string' &&
    typeof (data as DoctorDTO).lastName === 'string'  &&
    typeof (data as DoctorDTO).speciality === 'string' 
  ) {
    return true;
  }

  return false;
}

export function isDoctorDTO(data: unknown): data is DoctorDTO {
  return isDoctor(data);
}

/**
 * Function that validates that an input is a valid Doctor model
 * @param data 
 * @returns true if data is a valid Doctor model
 */
export function isNewDoctor(data: unknown): data is NewDoctorDTO {
  if (
    data && typeof data === 'object' &&
    'firstName' in data && 'lastName' in data &&
    'speciality' in data &&
    typeof (data as NewDoctorDTO).firstName === 'string' &&
    typeof (data as NewDoctorDTO).lastName === 'string'  &&
    typeof (data as NewDoctorDTO).speciality === 'string' 
  ) {
    return true;
  }
  return false;
}

/**
 * Function that validates that an input is a valid Patient model
 * @param data 
 * @returns true if data is a valid Patient model
 */
export function isPatient(data: unknown): data is PatientDTO {
  if(
    data && typeof data === 'object' &&
    ((data as PatientDTO).id === undefined || typeof (data as PatientDTO).id == 'number') &&
    'firstName' in data && 'lastName' in data &&
    'birthDate' in data && 'niss' in data &&
    'address' in data && 'refDoctor' in data &&
    typeof (data as PatientDTO).firstName === 'string' &&
    ((typeof (data as PatientDTO).birthDate === 'string') || ((data as PatientDTO).birthDate as any) instanceof Date) &&
    typeof (data as PatientDTO).niss === 'string' &&
    typeof (data as PatientDTO).address === 'object' && isAddress((data as PatientDTO).address) &&
    typeof (data as PatientDTO).refDoctor === 'number'
  ) {
    return true;
  }
  return false;
}

export function isNewPatient(data: unknown): data is NewPatientDTO {
  if (
    data && typeof data === 'object' &&
    'firstName' in data && 'lastName' in data &&
    'birthDate' in data && 'niss' in data &&
    'address' in data &&
    typeof (data as NewPatientDTO).firstName === 'string' &&
    ((typeof (data as NewPatientDTO).birthDate === 'string') || (isDate((data as NewPatientDTO).birthDate))) &&
    typeof (data as NewPatientDTO).niss === 'string' &&
    typeof (data as NewPatientDTO).address === 'object' && isAddress((data as NewPatientDTO).address) 
  ) {
    return true;
  }
  return false;
}

/**
 * Function that validates that an input is a valid Address
 * @param data any data
 * @returns true if data is a valid Address
 */
function isAddress(data: any): data is AddressDTO {
  return data && typeof data === 'object' &&
  typeof((data as AddressDTO).street) === 'string' && typeof((data as AddressDTO).number) === 'string' &&
  typeof((data as AddressDTO).zipCode) === 'string' && typeof((data as AddressDTO).city) === 'string' &&
  typeof((data as AddressDTO).country) === 'string';
}

/**
 * Function that validates that an input is a valid niss
 * A valid niss is a string with the following format: XXXXXX-XXX-XX
 * @param data any data
 * @returns true if data is a valid niss
 */
export function isNiss(data: any): data is String {
  return typeof data === 'string' && 
  data.match(/^\d{6}-\d{3}-\d{2}$/) !== null;
}

export function isDate(data: unknown): data is Date{
  return data != null && data != undefined && (typeof data === 'object') && (data instanceof Date);
}

// export function isNewUser(data: unknown): data is NewUserDTO {
//   return data != null && data != undefined && typeof data === 'object' &&
//     (data as NewUserDTO).lastName in data && (data as NewUserDTO).firstName in data &&
//     (data as NewUserDTO).email in data && (data as NewUserDTO).password in data &&
//     (data as NewUserDTO).role in data && (data as NewUserDTO).username in data &&
//     isString((data as NewUserDTO).password) &&
//     (data as NewUserDTO).email === 'string' &&
//     (data as NewUserDTO).firstName === 'string' &&
//     (data as NewUserDTO).lastName === 'string' &&
//     (data as NewUserDTO).password === 'string' &&
//     isNumber((data as NewUserDTO).role) &&
//     (data as NewUserDTO).username === 'string';
// }

// export function isAppointment(data: unknown): data is AppointmentDTO {
//   return data != undefined && typeof data === 'object' &&
//   ((data as AppointmentDTO).id === undefined || typeof (data as AppointmentDTO).id == 'number') &&
//   // 'date' in data && 'doctor' in data &&
//   // 'patient' in data && 'status' in data &&
//   (typeof (data as AppointmentDTO).dateTime === 'string' || (typeof (data as AppointmentDTO).dateTime === 'object') && isDate((data as AppointmentDTO).dateTime)) &&
//   isNumber((data as Appointment).doctorId) &&
//   isNumber((data as Appointment).patientId) &&
//   (typeof (data as Appointment).status === 'string');
// }

// export function isAppointment(data: unknown): data is AppointmentDTO {
//   return data != undefined && typeof data === 'object' &&
//   isNewAppointment(data) &&
//   ((data as AppointmentDTO).id === undefined || typeof (data as AppointmentDTO).id == 'number');
// }

// export function isNewAppointment(data: unknown): data is NewAppointmentDTO {
//   return data != undefined && typeof data === 'object' &&
//     'dateTime' in data && 'doctorId' in data && 'patientId' in data &&
//     isString((data as NewAppointmentDTO).dateTime) &&
//     isNumber((data as NewAppointmentDTO).doctorId) &&
//     isNumber((data as NewAppointmentDTO).patientId);
// }

// export function isAppointmentStatus(data: string): data is EAppointmentStatus {
//   return (Object.values(EAppointmentStatus) as string[]).includes(data);
// }
