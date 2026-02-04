/**
 * This file contains all the logic for the doctors controller
 */

import { Request, Response, Router } from "express";
import { Doctor } from "../models/doctor.model";

export const doctorsController = Router();

// This is a static mock array of doctors
const doctors: Doctor[] = [
  {id:1, firstName: "Jules", lastName: "Valles", speciality: "Cardiologue"}, 
  {id:2, firstName: "Safouane", lastName: "Van Brussels", speciality: "General Practicien"},
  {id:3, firstName: "Paola", lastName: "Sanchez", speciality: "pulmonologist"} 
];

/**
 * This function returns all the doctors
 */
doctorsController.get("/", (req: Request, res: Response) => {
  console.log("[GET] /doctors/");
  res.json(doctors).status(200);
});
