import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { EquiposService } from './equipos.service';
import { Observable } from 'rxjs';
import { Equipo } from '../modelo/equipo';
import { map } from 'rxjs/operators';

const url_base = 'https://equiipo-club-api.herokuapp.com/api/equipos';

@Injectable({
  providedIn: 'root'
})
export class EquiposApiService extends EquiposService {

  constructor(private http: HttpClient) { super(); }



  getEquipos(): Observable<Equipo[]>{
    return this.http.get(`${url_base}?sort=nombre,asc&size=999`).pipe(
      map(respuesta => respuesta['_embedded'] ? respuesta['_embedded'].equipos : [])
    )
  }

  getIdEquipo(equipo): any{
    let href = equipo['_links'].self.href;
    return href.slice(href.lastIndexOf('/') + 1);
  }

  getEquipoPorId (id: string): Observable<Equipo>{
    return this.http.get(`${url_base}/${id}`).pipe(
      map(respuesta => respuesta as Equipo)
    )
  }
  getEquipoPorJugadorNombre (nombre: string): Observable<Equipo>{
    return this.http.get(`${url_base}/search/nombre-jugador?nombreJugador=${nombre}`).pipe(
      map(respuesta => respuesta as Equipo)
    )
  }


}
