/**
 * This file contains all the logic for the doctors controller
 */

import { Request, Response, Router } from "express";
import { isNumber } from "../utils/guards"; 
import { Doctor , DoctorDTO } from "../models/doctor.model";
import { DoctorsMapper } from "../mappers/doctors.mapper";

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
  
  const doctorsDTO: DoctorDTO[] = [];
  for (const i of doctors) {
    doctorsDTO.push(DoctorsMapper.toDTO(i));
  }
  
  res.status(200).send(doctorsDTO);
});


// GET /doctors/1  →  retourne le docteur avec id=1
doctorsController.get("/:id", (req: Request, res: Response) => {
  console.log("[GET] /doctors/:id");

    // 1️⃣ Transformer le paramètre en nombre
  const id = parseInt(req.params.id);

  // 2️⃣ Vérifier que c’est bien un nombre valide
  if (!isNumber(id)) {
    res.status(400).send("ID must be a number");
    return;
  }

  // 3️⃣ Parcourir la liste avec une boucle for
  for (let i = 0; i < doctors.length; i++) {
    if (doctors[i].id === id) {
        // transform dto
        const doctorDTO = DoctorsMapper.toDTO(doctors[i]);
        
      // 5️⃣ Docteur trouvé
      res.status(200).json(doctorDTO);
      return;
    }
  }

  // 4️⃣ Docteur non trouvé
  res.status(404).send("Doctor not found");
});

// cree une route post cree un nouveau docteur
doctorsController.post("/", (req: Request, res: Response) => {
  console.log("[POST] /doctors/");
  const { firstName, lastName, speciality } = req.body;
  
  // Validation des données d'entrée
  if (!firstName || !lastName || !speciality) {
    res.status(400).send("Missing required fields: firstName, lastName, speciality");
    return;
  }
  
  // Création du nouveau docteur
  const newDoctor: Doctor = {
    id: doctors.length + 1, // Générer un nouvel ID (simplement en incrémentant la longueur du tableau)
    firstName,
    lastName,
    speciality
  };
  
  // Ajouter le nouveau docteur à la liste
  doctors.push(newDoctor);
  
  // Retourner le docteur créé avec un statut 201
  res.status(201).json(DoctorsMapper.toDTO(newDoctor));
});

 