import { Equipo } from './equipo';

export interface Entrenador{
    nombre: string,
    nif: string,
    licencias: string[],
    equipos: Equipo[]
}