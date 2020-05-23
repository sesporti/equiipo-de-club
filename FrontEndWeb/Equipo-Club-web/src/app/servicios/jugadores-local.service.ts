import { jugadores_data } from './../data/jugadores.data';
import { JugadoresService } from 'src/app/servicios/jugadores.service';
import { Injectable } from '@angular/core';
import { of, Observable } from 'rxjs';
import { Jugador } from '../modelo/jugador';

@Injectable({
  providedIn: 'root'
})
export class JugadoresLocalService extends JugadoresService{
    
  jugadores = jugadores_data;

  constructor() { super() }

  getJugadores(): Observable<Jugador[]> {
    return of(this.jugadores) as Observable<Jugador[]>;
  }

  getIdJugador(jugador) {
    return this.jugadores.indexOf(jugador);
  }

  getJugadorPorId(id: string): Observable<Jugador> {
    return of(this.jugadores[id]) as Observable<Jugador>;
  }

  getJugadoresPorNombre(nombre: string): Observable<Jugador[]> {
    return of(this.jugadores.filter(
      (jugador) => {
        return jugador.nombre.toUpperCase().includes(nombre.toUpperCase())
      }
    )) as Observable<Jugador[]>
  }
  getJugadoresPorEdad(edad: number): Observable<Jugador[]> {
    return of(this.jugadores.filter(
      (jugador) => {
        return jugador.edad == edad
      }
    )) as Observable<Jugador[]>
  }
  getJugadoresPorEdadesLicencia(edadMin: number, edadMax: number): Observable<Jugador[]> {
    return of(this.jugadores.filter(
      (jugador) => {
        return jugador.edad >= edadMin && jugador.edad <= edadMax
      }
    )) as Observable<Jugador[]>
  }
  getJugadoresPorNombreEquipo(nombreEquipo: string): Observable<Jugador[]> {
    throw new Error("Method not implemented.");
  }
  getJugadoresPorLicencia(licencia: string): Observable<Jugador[]> {
    throw new Error("Method not implemented.");
  }
  getJugadoresPorCategoria(categoria: string): Observable<Jugador[]> {
    throw new Error("Method not implemented.");
  }
  crearJugador(jugador: Jugador) {
    this.jugadores.push(jugador);
    return of(null);
  }
  modificarJugador(id: string, jugador: Jugador) {
    this.jugadores[id] = jugador;
    return of(null);
  }
  borrarJugador(id: any): Observable<Object> {
    this.jugadores.splice(id,1);
    return of(null);
  }
}
