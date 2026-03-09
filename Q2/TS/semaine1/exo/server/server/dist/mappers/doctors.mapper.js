"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.DoctorsMapper = void 0;
class DoctorsMapper {
    static toDTO(doctor) {
        return {
            id: doctor.id,
            firstName: doctor.firstName,
            lastName: doctor.lastName,
            speciality: doctor.speciality,
        };
    }
}
exports.DoctorsMapper = DoctorsMapper;
