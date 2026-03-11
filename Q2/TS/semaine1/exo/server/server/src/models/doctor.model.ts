import { Person } from "./person.model";

// Représentation interne complète (avec id via Person)
export interface Doctor extends Person {
  speciality: string;
}

// Ce qu'on envoie au client (même chose que Doctor ici)
export interface DoctorDTO extends Person {
  speciality: string;
}

// Ce que le client envoie pour CRÉER un docteur (pas d'id)
export interface NewDoctorDTO {
  firstName: string;
  lastName: string;
  speciality: string;
}

// Représentation interne d'un docteur à créer (pas d'id)
export interface NewDoctor {
  firstName: string;
  lastName: string;
  speciality: string;
}
export interface DoctorsFilter {
  speciality?: string;
}
