import { Person } from "./person.model";

export interface Doctor extends Person {
  speciality: string;
}
