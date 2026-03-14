import { Address } from "./address.model";
import { Person } from "./person.model";

// Person contient déjà id, firstName, lastName
export interface Patient extends Person {
  birthDate: Date;   // minuscule au début (convention TypeScript)
  niss: string;
  address: Address;
  refDoctor: number;
}

// Tous les champs du patient → même chose que Patient
export interface PatientDTO extends Person {
  birthDate: Date;
  niss: string;
  address: Address;
  refDoctor: number;
}

// Seulement id, firstName, lastName → pas d'extension de Person
export interface PatientShortDTO {
  id: number;
  firstName: string;
  lastName: string;
}
//newPatientDTO pour la création d'un patient
export interface NewPatientDTO {
  firstName: string;
  lastName: string;
  birthDate: string; // format "YYYY-MM-DD"
  niss: string;
  address: Address;
  refDoctor: number;
}
