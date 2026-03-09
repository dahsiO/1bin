"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.PatientController = void 0;
const express_1 = require("express");
const guards_1 = require("../utils/guards");
exports.PatientController = (0, express_1.Router)();
// This is a static mock array of patients  
const patients = [
    {
        id: 1,
        firstName: "Jean",
        lastName: "Dupont",
        birthDate: new Date("1980-01-01"),
        niss: "123456789",
        address: {
            street: "Main Street",
            number: "123",
            zipCode: "1000",
            city: "Brussels",
            country: "Belgium"
        },
        refDoctor: 1
    },
    {
        id: 2,
        firstName: "Marie",
        lastName: "Curie",
        birthDate: new Date("1975-05-15"),
        niss: "987654321",
        address: {
            street: "Second Street",
            number: "456",
            zipCode: "2000",
            city: "Antwerp",
            country: "Belgium"
        },
        refDoctor: 2
    }
];
/** * This function returns all the patients
 */
exports.PatientController.get("/", (req, res) => {
    console.log("[GET] /patients/");
    res.json(patients).status(200);
});
// GET /patients/1  →  retourne le patient avec id=1
exports.PatientController.get("/:id", (req, res) => {
    console.log("[GET] /patients/:id");
    const id = parseInt(req.params.id);
    const patient = patients.find(p => p.id === id);
    if (patient) {
        res.json(patient).status(200);
    }
    else {
        res.status(404).send("Patient not found");
    }
});
//return patient by niss
exports.PatientController.get("/:niss", (req, res) => {
    console.log(`[GET] /patients/:niss')`);
    const niss = req.params.niss;
    if (!(0, guards_1.isNiss)(niss)) {
        res.status(400).json({ error: "niss must be in the format 123456-123-45" });
        return;
    }
    for (let i = 0; i < patients.length; i++) {
        if (patients[i].niss === niss) {
            res.json(patients[i]).status(200);
            return;
        }
    }
    res.status(404).json({ error: "Patient not found" });
});
// create a new route get patient by id short :id/short only return id, firstName and lastName
exports.PatientController.get("/:id/short", (req, res) => {
    console.log("[GET] /patients/:id/short");
    const id = parseInt(req.params.id);
    if (!(0, guards_1.isNumber)(id)) {
        res.status(400).json({ error: "ID must be a number" });
        return;
    }
    for (let i = 0; i < patients.length; i++) {
        if (patients[i].id === id) {
            const { firstName, lastName } = patients[i];
            res.json({ id, firstName, lastName }).status(200);
            return;
        }
    }
    res.status(404).json({ error: "Patient not found" });
});
// create a new route get patient by zip code : zip/:zip only return id, firstName and lastName of patients with the same zip code
exports.PatientController.get("/zip/:zip", (req, res) => {
    console.log("[GET] /patients/zip/:zip");
    const zip = req.params.zip;
    const patientsByZip = patients.filter(p => p.address.zipCode === zip);
    if (patientsByZip.length > 0) {
        const result = patientsByZip.map(p => ({ id: p.id, firstName: p.firstName, lastName: p.lastName }));
        res.json(result).status(200);
    }
    else {
        res.status(404).json({ error: "No patients found with this zip code" });
    }
});
