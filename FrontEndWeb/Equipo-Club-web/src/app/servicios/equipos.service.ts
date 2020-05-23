import { Observable } from 'rxjs';
import { Equipo } from '../modelo/equipo';

export abstract class EquiposService{

    abstract getEquipos(): Observable<Equipo[]>;

    abstract getIdEquipo(equipo): any;

    abstract getEquipoPorId (id: string): Observable<Equipo>;

    abstract getEquipoPorJugadorNombre (nombre: string): Observable<Equipo>;
    
}