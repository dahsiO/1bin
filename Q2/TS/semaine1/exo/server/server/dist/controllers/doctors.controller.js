"use strict";
/**
 * This file contains all the logic for the doctors controller
 */
Object.defineProperty(exports, "__esModule", { value: true });
exports.doctorsController = void 0;
const express_1 = require("express");
const guards_1 = require("../utils/guards");
const doctors_mapper_1 = require("../mappers/doctors.mapper");
exports.doctorsController = (0, express_1.Router)();
// This is a static mock array of doctors
const doctors = [
    { id: 1, firstName: "Jules", lastName: "Valles", speciality: "Cardiologue" },
    { id: 2, firstName: "Safouane", lastName: "Van Brussels", speciality: "General Practicien" },
    { id: 3, firstName: "Paola", lastName: "Sanchez", speciality: "pulmonologist" }
];
/**
 * This function returns all the doctors
 */
exports.doctorsController.get("/", (req, res) => {
    console.log("[GET] /doctors/");
    const doctorsDTO = [];
    for (const i of doctors) {
        doctorsDTO.push(doctors_mapper_1.DoctorsMapper.toDTO(i));
    }
    res.status(200).send(doctorsDTO);
});
// GET /doctors/1  →  retourne le docteur avec id=1
exports.doctorsController.get("/:id", (req, res) => {
    console.log("[GET] /doctors/:id");
    // 1️⃣ Transformer le paramètre en nombre
    const id = parseInt(req.params.id);
    // 2️⃣ Vérifier que c’est bien un nombre valide
    if (!(0, guards_1.isNumber)(id)) {
        res.status(400).send("ID must be a number");
        return;
    }
    // 3️⃣ Parcourir la liste avec une boucle for
    for (let i = 0; i < doctors.length; i++) {
        if (doctors[i].id === id) {
            // transform dto
            const doctorDTO = doctors_mapper_1.DoctorsMapper.toDTO(doctors[i]);
            // 5️⃣ Docteur trouvé
            res.status(200).json(doctorDTO);
            return;
        }
    }
    // 4️⃣ Docteur non trouvé
    res.status(404).send("Doctor not found");
});
