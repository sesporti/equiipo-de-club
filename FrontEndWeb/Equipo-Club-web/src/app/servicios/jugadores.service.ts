import { Observable } from 'rxjs';
import { Jugador } from '../modelo/jugador';

export abstract class JugadoresService {

    abstract getJugadores(): Observable<Jugador[]>;

    abstract getIdJugador(jugador): any;

    abstract getJugadorPorId(id:string): Observable<Jugador>;

    abstract getJugadoresPorNombre (nombre: string): Observable<Jugador[]>;

    abstract getJugadoresPorEdad (edad: number): Observable<Jugador[]>;

    abstract getJugadoresPorEdadesLicencia (edadMin: number, edadMax: number):  Observable<Jugador[]>;

    abstract getJugadoresPorNombreEquipo (nombreEquipo: string):  Observable<Jugador[]>;

    abstract getJugadoresPorLicencia (licencia: string): Observable<Jugador[]>;

    abstract getJugadoresPorCategoria (categoria: string):  Observable<Jugador[]>;

    abstract crearJugador (jugador: Jugador);

    abstract modificarJugador (id: string, jugador: Jugador);

    abstract borrarJugador (id: string): Observable<Object>;
}