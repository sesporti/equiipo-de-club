import { Observable } from 'rxjs';
import { Asistencia } from '../modelo/asistencia';
import { Jugador } from '../modelo/jugador';

export abstract class AsistenciasService {
  
  abstract getAsistencias(): Observable<Asistencia[]>;
  
  abstract getAsistenciasConJugador(filtro): Observable<Asistencia[]>;

  abstract getAsistenciasJugador(jugador:Jugador): Observable<Asistencia[]>;

  abstract getAsistenciasPorTipo(valor): Observable<Asistencia[]>;

  abstract getAsistenciasPorEquipo(equipo): Observable<Asistencia[]>;
  
  abstract getAsistenciasPorEquipoYTipo(equipo, valor): Observable<Asistencia[]>;
  
  abstract getAsistenciasPorFecha(fecha): Observable<Asistencia[]>;
  
  abstract getAsistenciasEntreFechas(fechaIni, fechaFin): Observable<Asistencia[]>;

  abstract getAsistenciaPorId(id: string): Observable<Asistencia>;

  abstract getIdAsistencia(asistencia): any;

  abstract crearAsistencia(asistencia: Asistencia);

  abstract modificarAsistencia(id: string, asistencia: Asistencia);

  abstract borrarAsistencia(id): Observable<Object>;
}
