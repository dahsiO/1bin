"use strict";
// import { Address } from "../models/address.model";
// import { Appointment, AppointmentDTO, EAppointmentStatus, NewAppointmentDTO } from "../models/appointment.model";
// import { Doctor } from "../models/doctor.model";
// import { NewDoctorDTO } from "../models/doctor.model";
// import { NewPatientDTO, Patient, PatientDTO } from "../models/patient.model";
// import { DoctorDTO } from "../models/doctor.model";
// import { NewUserDTO } from "../models/user.model";
// import { MedicalExam } from "../models/medical_exam.model";
Object.defineProperty(exports, "__esModule", { value: true });
exports.isNumber = isNumber;
exports.isString = isString;
exports.isNiss = isNiss;
exports.isDate = isDate;
/**
 * Function that validates that an input is a number
 * @param data any data
 * @returns true if data is a number
 */
function isNumber(data) {
    return data !== undefined && data !== null && typeof data === 'number' && !isNaN(data);
}
/**
 * Function that validates that an input is a string
 * @param data any data
 * @returns true if data is a string
*/
function isString(data) {
    return data !== undefined && data !== null && typeof data === 'string';
}
/**
 * Function that validates that an input is a valid Doctor model
 * @param data
 * @returns true if data is a valid Doctor model
 */
// export function isDoctor(data: unknown): data is Doctor {
//   if (
//     data && typeof data === 'object' &&
//     ((data as Doctor).id === undefined || typeof (data as Doctor).id == 'number') &&
//     'firstName' in data && 'lastName' in data &&
//     'speciality' in data &&
//     typeof (data as Doctor).firstName === 'string' &&
//     typeof (data as Doctor).lastName === 'string'  &&
//     typeof (data as Doctor).speciality === 'string' 
//   ) {
//     return true;
//   }
//   return false;
// }
// export function isDoctorDTO(data: unknown): data is DoctorDTO {
//   return isDoctor(data);
// }
// /**
//  * Function that validates that an input is a valid Doctor model
//  * @param data 
//  * @returns true if data is a valid Doctor model
//  */
// export function isNewDoctor(data: unknown): data is NewDoctorDTO {
//   if (
//     data && typeof data === 'object' &&
//     'firstName' in data && 'lastName' in data &&
//     'speciality' in data &&
//     typeof (data as NewDoctorDTO).firstName === 'string' &&
//     typeof (data as NewDoctorDTO).lastName === 'string'  &&
//     typeof (data as NewDoctorDTO).speciality === 'string' 
//   ) {
//     return true;
//   }
//   return false;
// }
/**
 * Function that validates that an input is a valid Patient model
 * @param data
 * @returns true if data is a valid Patient model
 */
// export function isPatient(data: unknown): data is PatientDTO {
//   if(
//     data && typeof data === 'object' &&
//     ((data as Patient).id === undefined || typeof (data as Patient).id == 'number') &&
//     'firstName' in data && 'lastName' in data &&
//     'birthDate' in data && 'niss' in data &&
//     'address' in data && 'refDoctor' in data &&
//     typeof (data as Patient).firstName === 'string' &&
//     ((typeof (data as Patient).birthDate === 'string') || ((data as Patient).birthDate instanceof Date)) &&
//     typeof (data as Patient).niss === 'string' &&
//     typeof (data as Patient).address === 'object' && isAddress((data as Patient).address) &&
//     typeof (data as Patient).refDoctor === 'number'
//   ) {
//     return true;
//   }
//   return false;
// }
// export function isNewPatient(data: unknown): data is NewPatientDTO {
//   if (
//     data && typeof data === 'object' &&
//     'firstName' in data && 'lastName' in data &&
//     'birthDate' in data && 'niss' in data &&
//     'address' in data &&
//     typeof (data as NewPatientDTO).firstName === 'string' &&
//     ((typeof (data as NewPatientDTO).birthDate === 'string') || (isDate((data as NewPatientDTO).birthDate))) &&
//     typeof (data as NewPatientDTO).niss === 'string' &&
//     typeof (data as NewPatientDTO).address === 'object' && isAddress((data as NewPatientDTO).address) 
//   ) {
//     return true;
//   }
//   return false;
// }
/**
 * Function that validates that an input is a valid Address
 * @param data any data
 * @returns true if data is a valid Address
 */
// function isAddress(data: any): data is Address {
//   return data && typeof data === 'object' &&
//   typeof((data as Address).street) === 'string' && typeof((data as Address).number) === 'string' &&
//   typeof((data as Address).zipCode) === 'string' && typeof((data as Address).city) === 'string' &&
//   typeof((data as Address).country) === 'string';
// }
/**
 * Function that validates that an input is a valid niss
 * A valid niss is a string with the following format: XXXXXX-XXX-XX
 * @param data any data
 * @returns true if data is a valid niss
 */
function isNiss(data) {
    return typeof data === 'string' &&
        data.match(/^\d{6}-\d{3}-\d{2}$/) !== null;
}
function isDate(data) {
    return data != null && data != undefined && (typeof data === 'object') && (data instanceof Date);
}
// export function isNewUser(data: unknown): data is NewUserDTO {
//   return data != null && data != undefined && typeof data === 'object' &&
//     'lastName' in data && 'firstName' in data &&
//     'email' in data && 'password' in data &&
//     'role' in data && 'username' in data &&
//     isString((data as NewUserDTO).password) &&
//     isString((data as NewUserDTO).email) &&
//     isString((data as NewUserDTO).firstName) &&
//     isString((data as NewUserDTO).lastName) &&
//     isNumber((data as NewUserDTO).role) &&
//     isString((data as NewUserDTO).username);
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
// export function isMedicalExam(data: unknown): data is MedicalExam {
//   if(
//     data != undefined && typeof data === 'object' &&
//     // ('id' in data) &&
//     ((data as MedicalExam).id === undefined || typeof (data as MedicalExam).id == 'number') &&
//     ('dateTime' in data) && 
//     ('patientId' in data) && ('doctorId' in data) &&
//     // ('status' in data) &&
//     (typeof (data as MedicalExam).dateTime === 'string' || ((typeof (data as MedicalExam).dateTime === 'object') && isDate((data as MedicalExam).dateTime))) &&
//     isNumber((data as MedicalExam).patientId) &&
//     isNumber((data as MedicalExam).doctorId) &&
//     // status is not required in case of creation
//     ((data as MedicalExam).status === undefined || typeof (data as MedicalExam).status == 'string')
//     // isNumber((data as MedicalExamDTO).appointmentId) &&
//     // (typeof (data as MedicalExam).type === 'string') &&
//     // (typeof (data as MedicalExam).notes === 'string') &&
//     // (typeof (data as MedicalExam).status === 'string')
//   ){
//     return true;
//   }
//   return false;
// }
// export function isAppointmentStatus(data: string): data is EAppointmentStatus {
//   return (Object.values(EAppointmentStatus) as string[]).includes(data);
// }
