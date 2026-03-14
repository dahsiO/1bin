"use strict";
/**
 * This file contains all the logic for the doctors controller
 */
Object.defineProperty(exports, "__esModule", { value: true });
exports.doctorsController = void 0;
const express_1 = require("express");
const guards_1 = require("../utils/guards");
const doctors_mapper_1 = require("../mappers/doctors.mapper");
const logger_service_1 = require("../services/logger.service");
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
    logger_service_1.LoggerService.info(`[GET] /doctors/`);
    const doctorsDTO = [];
    for (const i of doctors) {
        doctorsDTO.push(doctors_mapper_1.DoctorsMapper.toDTO(i));
    }
    res.status(200).send(doctorsDTO);
});
// filter by speciality with DoctorsFilter interface
exports.doctorsController.get("/filter", (req, res) => {
    logger_service_1.LoggerService.info(`[GET] /doctors/filter`);
    const speciality = req.query.speciality;
    // Validation de la spécialité
    if (!(0, guards_1.isString)(speciality)) {
        res.status(400).send("Speciality must be a string");
        return;
    }
    const doctorsDTO = [];
    for (const doctor of doctors) {
        if (doctor.speciality.toLowerCase() === speciality.toLowerCase()) {
            doctorsDTO.push(doctors_mapper_1.DoctorsMapper.toDTO(doctor));
        }
    }
    // Retourner les docteurs filtrés
    res.status(200).json(doctorsDTO);
});
// GET /doctors/1  →  retourne le docteur avec id=1
exports.doctorsController.get("/:id", (req, res) => {
    logger_service_1.LoggerService.info("[GET] /doctors/:id");
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
// cree une route post cree un nouveau docteur
exports.doctorsController.post("/", (req, res) => {
    logger_service_1.LoggerService.info("[POST] /doctors/");
    const { firstName, lastName, speciality } = req.body;
    // Validation des données d'entrée
    if (!firstName || !lastName || !speciality) {
        res.status(400).send("Missing required fields: firstName, lastName, speciality");
        return;
    }
    // Création du nouveau docteur
    const newDoctor = {
        id: doctors.length + 1, // Générer un nouvel ID (simplement en incrémentant la longueur du tableau)
        firstName,
        lastName,
        speciality
    };
    // Ajouter le nouveau docteur à la liste
    doctors.push(newDoctor);
    // Retourner le docteur créé avec un statut 201
    res.status(201).json(doctors_mapper_1.DoctorsMapper.toDTO(newDoctor));
});
// put /doctors/1  →  met à jour le docteur avec id=1
exports.doctorsController.put("/:id", (req, res) => {
    logger_service_1.LoggerService.info("[PUT] /doctors/:id");
    const id = parseInt(req.params.id);
    // Validation de l'ID
    if (!(0, guards_1.isNumber)(id)) {
        res.status(400).send("ID must be a number");
        return;
    }
    const { firstName, lastName, speciality } = req.body;
    // Validation des données d'entrée
    if (!firstName || !lastName || !speciality) {
        res.status(400).send("Missing required fields: firstName, lastName, speciality");
        return;
    }
    // Trouver le docteur à mettre à jour
    for (let i = 0; i < doctors.length; i++) {
        if (doctors[i].id === id) {
            // Mettre à jour les informations du docteur
            doctors[i].firstName = firstName;
            doctors[i].lastName = lastName;
            doctors[i].speciality = speciality;
            // Retourner le docteur mis à jour
            res.status(200).json(doctors_mapper_1.DoctorsMapper.toDTO(doctors[i]));
            return;
        }
    }
    // Docteur non trouvé
    res.status(404).send("Doctor not found");
});
// delete /doctors/1  →  supprime le docteur avec id=1
exports.doctorsController.delete("/:id", (req, res) => {
    logger_service_1.LoggerService.info("[DELETE] /doctors/:id");
    const id = parseInt(req.params.id);
    // Validation de l'ID
    if (!(0, guards_1.isNumber)(id)) {
        res.status(400).send("ID must be a number");
        return;
    }
    // Trouver l'index du docteur à supprimer bloucle for
    for (let i = 0; i < doctors.length; i++) {
        if (doctors[i].id === id) {
            // Supprimer le docteur du tableau
            doctors.splice(i, 1);
            // Retourner un statut 204 No Content
            res.status(204).send();
            return;
        }
    }
    // Docteur non trouvé
    res.status(404).send("Doctor not found");
});
