"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.PatientsMapper = void 0;
class PatientsMapper {
    static toDTO(patient) {
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
    static toShortDTO(patient) {
        return {
            id: patient.id,
            firstName: patient.firstName,
            lastName: patient.lastName,
        };
    }
    //new method to create a patient fromNewDTO
    static fromNewDTO(patientDTO) {
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
exports.PatientsMapper = PatientsMapper;
