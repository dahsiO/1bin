"use strict";
/**
 * This file contains all the logic for the doctors controller
 */
Object.defineProperty(exports, "__esModule", { value: true });
exports.doctorsController = void 0;
const express_1 = require("express");
const guards_1 = require("../utils/guards");
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
    res.json(doctors).status(200);
});
// GET /doctors/1  →  retourne le docteur avec id=1
exports.doctorsController.get("/:id", (req, res) => {
    console.log("[GET] /doctors/:id");
    // 1️⃣ Transformer le paramètre en nombre
    const id = Number(req.params.id);
    // 2️⃣ Vérifier que c’est bien un nombre valide
    if (!(0, guards_1.isNumber)(id)) {
        res.status(400).send("ID must be a number");
        return;
    }
    // 3️⃣ Parcourir la liste avec une boucle for
    for (let i = 0; i < doctors.length; i++) {
        if (doctors[i].id === id) {
            // 5️⃣ Docteur trouvé
            res.status(200).json(doctors[i]);
            return;
        }
    }
    // 4️⃣ Docteur non trouvé
    res.status(404).send("Doctor not found");
});
