"use strict";
/**
 * This file contains all the logic for the doctors controller
 */
Object.defineProperty(exports, "__esModule", { value: true });
exports.doctorsController = void 0;
const express_1 = require("express");
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
