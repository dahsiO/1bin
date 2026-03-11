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
    // toEntity(dto: DoctorDTO): Doctor 
    static toEntity(dto) {
        return {
            id: dto.id,
            firstName: dto.firstName,
            lastName: dto.lastName,
            speciality: dto.speciality,
        };
    }
}
exports.DoctorsMapper = DoctorsMapper;
