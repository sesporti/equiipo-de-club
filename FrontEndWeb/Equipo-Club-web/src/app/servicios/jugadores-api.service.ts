import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JugadoresService } from './jugadores.service';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { Jugador } from '../modelo/jugador';

const url_base = 'https://equiipo-club-api.herokuapp.com/api/jugadores';

@Injectable({
  providedIn: 'root'
})
export class JugadoresApiService extends JugadoresService{
  

  constructor(private http: HttpClient) { super() }

  getJugadores(): Observable<Jugador[]>{
    return this.http.get(`${url_base}?sort=nombre,asc&size=999`).pipe(
      map(respuesta => respuesta['_embedded'].jugadores)
    )
  }

  getIdJugador(jugador: Jugador): any{
    let href = jugador['_links'].self.href;
    return href.slice(href.lastIndexOf('/') + 1);
  }

  getJugadorPorId(id: string): Observable<Jugador> {
    return this.http.get(`${url_base}/${id}`).pipe(
      map(respuesta => respuesta as Jugador)
    )
  }

  getJugadoresPorNombre (nombre: string): Observable<Jugador[]>{
    return this.http.get(`${url_base}/search/nombre-contiene?txt=${nombre}`).pipe(
      map(respuesta => respuesta['_embedded'] ? respuesta['_embedded'].jugadores : [])
    )
  }

  getJugadoresPorEdad (edad: number): Observable<Jugador[]>{
    return this.http.get(`${url_base}/search/por-edad?edadJugador=${edad}`).pipe(
      map(respuesta => respuesta['_embedded'] ? respuesta['_embedded'].jugadores : [])
    )
  }

  getJugadoresPorEdadesLicencia (edadMin: number, edadMax: number):  Observable<Jugador[]>{
    return this.http.get(`${url_base}/search/por-edades-en-licencia?edadMinima=${edadMin}&edadMaxima=${edadMax}`).pipe(
      map(respuesta => respuesta['_embedded'] ? respuesta['_embedded'].jugadores : [])
    )
  }

  getJugadoresPorNombreEquipo (nombreEquipo: string):  Observable<Jugador[]>{
    return this.http.get(`${url_base}/search/nombre-equipo-contiene?txt=${nombreEquipo}`).pipe(
      map(respuesta => respuesta['_embedded'] ? respuesta['_embedded'].jugadores : [])
    )
  }

  getJugadoresPorLicencia (licencia: string): Observable<Jugador[]>{
    return this.http.get(`${url_base}/search/licencia-equipo?licencia=${licencia}`).pipe(
      map(respuesta => respuesta['_embedded'] ? respuesta['_embedded'].jugadores : [])
    )
  }

  getJugadoresPorCategoria (categoria: string):  Observable<Jugador[]>{
    return this.http.get(`${url_base}/search/categoria-equipo?categoria=${categoria}`).pipe(
      map(respuesta => respuesta['_embedded'] ? respuesta['_embedded'].jugadores : [])
    )
  }

  crearJugador (jugador: Jugador){
    return this.http.post(url_base,jugador);
  }

  modificarJugador (id: string, jugador: Jugador){
    return this.http.patch(`${url_base}/${id}`, jugador).pipe(
      catchError(
        (error: HttpErrorResponse) => {
          if (error.status === 404) {
            alert('Mensaje desde el Observable: Jugador no encontrado')
          }
          else {
            alert(`Mensaje desde el Observable: Error inesperado: ${error.message}`)
          }
          return [];
        }
      )
    );
  }

  borrarJugador (id: string): Observable<Object>{
    return this.http.delete(`${url_base}/${id}`);
  }
}
