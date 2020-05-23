import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Asistencia } from '../modelo/asistencia';
import { AsistenciasService } from './asistencias.service';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs/operators';
import { Jugador } from '../modelo/jugador';

const url_base_asistencias =
  'https://equiipo-club-api.herokuapp.com/api/asistencias';

@Injectable({
  providedIn: 'root',
})
export class AsistenciasApiService extends AsistenciasService {
  constructor(private http: HttpClient) {
    super();
  }

  getAsistencias(): Observable<Asistencia[]> {
    return this.http
      .get(`${url_base_asistencias}?sort=fecha,desc&size=999`)
      .pipe(
        map((respuesta) =>
          respuesta['_embedded'] ? respuesta['_embedded'].asistencias : []
        )
      );
  }

  getAsistenciasConJugador(filtro: any): Observable<Asistencia[]> {
    return this.http
      .get(
        `${url_base_asistencias}/search/nombreJugador-contiene?txtNombreJugador=${filtro}`
      )
      .pipe(
        map((respuesta) =>
          respuesta['_embedded']
            ? respuesta['_embedded'].asistencias.filter((asistencia) => {
                return asistencia.nombreJugador
                  .toUpperCase()
                  .includes(filtro.toUpperCase());
              })
            : []
        )
      );
  }

  getAsistenciasJugador(jugador: Jugador): Observable<Asistencia[]> {
    return this.http
      .get(
        `${url_base_asistencias}/search/jugador?jugador=${jugador._links.self.href}`
      )
      .pipe(
        map((respuesta) =>
          respuesta['_embedded'] ? respuesta['_embedded'].asistencias : []
        )
      );
  }

  getAsistenciasPorTipo(valor: any): Observable<Asistencia[]> {
    return this.http
      .get(
        `${url_base_asistencias}/search/tipoAsistencia?tipoAsistencia=${valor}`
      )
      .pipe(
        map((respuesta) =>
          respuesta['_embedded']
            ? respuesta['_embedded'].asistencias.filter((asistencia) => {
                return asistencia.tipoAsistencia
                  .toUpperCase()
                  .includes(valor.toUpperCase());
              })
            : []
        )
      );
  }

  getAsistenciasPorEquipo(equipo: any): Observable<Asistencia[]> {
    return this.http.get(url_base_asistencias).pipe(
      map((respuesta) =>
        respuesta['_embedded']
          ? respuesta['_embedded'].asistencias.filter((asistencia) => {
              return asistencia.equipoJugador.nombre
                .toUpperCase()
                .includes(equipo.toUpperCase());
            })
          : []
      )
    );
  }

  getAsistenciasPorEquipoYTipo(
    equipo: any,
    valor: any
  ): Observable<Asistencia[]> {
    return this.http.get(url_base_asistencias).pipe(
      map((respuesta) =>
        respuesta['_embedded']
          ? respuesta['_embedded'].asistencias.filter((asistencia) => {
              return (
                this.getAsistenciasPorEquipo(equipo) &&
                this.getAsistenciasPorTipo(valor)
              );
            })
          : []
      )
    );
  }

  getAsistenciasPorFecha(fecha: any): Observable<Asistencia[]> {
    return this.http
      .get(`${url_base_asistencias}/search/fecha?fecha=${fecha}`)
      .pipe(
        map((respuesta) =>
          respuesta['_embedded'] ? respuesta['_embedded'].asistencias : []
        )
      );
  }

  getAsistenciasEntreFechas(
    fechaIni: any,
    fechaFin: any
  ): Observable<Asistencia[]> {
    return this.http
      .get(
        `${url_base_asistencias}/search/entre-fechas?fechaInicial=${fechaIni}&fechaFin=${fechaFin}`
      )
      .pipe(
        map((respuesta) =>
          respuesta['_embedded'] ? respuesta['_embedded'].asistencias : []
        )
      );
  }

  getAsistenciaPorId(id: string): Observable<Asistencia> {
    return this.http
      .get(`${url_base_asistencias}/${id}`)
      .pipe(map((respuesta) => respuesta as Asistencia));
  }

  getIdAsistencia(asistencia: Asistencia) {
    let href = asistencia['_links'].self.href;
    return href.slice(href.lastIndexOf('/') + 1);
  }

  crearAsistencia(asistencia: Asistencia) {
    return this.http.post(url_base_asistencias, asistencia);
  }

  modificarAsistencia(id: string, asistencia: Asistencia) {
    return this.http.patch(`${url_base_asistencias}/${id}`, asistencia).pipe(
      catchError((error: HttpErrorResponse) => {
        if (error.status === 404) {
          alert('Mensaje desde el Observable: Asistencia no encontrada');
        } else {
          alert(
            `Mensaje desde el Observable: Error inesperado: ${error.message}`
          );
        }
        return [];
      })
    );
  }

  borrarAsistencia(id: any): Observable<Object> {
    return this.http.delete(`${url_base_asistencias}/${id}`);
  }
}
