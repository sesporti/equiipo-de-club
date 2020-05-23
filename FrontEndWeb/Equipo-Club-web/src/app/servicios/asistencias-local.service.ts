import { Injectable } from '@angular/core';
import { AsistenciasService } from './asistencias.service';
import { asistencias_data1 } from './../data/asistencias1.data';
import { of, Observable } from 'rxjs';
import { Asistencia } from '../modelo/asistencia';
import { Jugador } from '../modelo/jugador';
// import { asistencias_data } from '../data/asistencias.data';

@Injectable()
export class AsistenciasLocalService extends AsistenciasService {
    
  asistencias = asistencias_data1;

  constructor() {
    super();
  }

  getAsistencias() {
    return of(this.asistencias)  as Observable<Asistencia[]>;
  }

  getAsistenciasConJugador(filtro) {
    return of(this.asistencias.filter((asistencia) => {
      let contieneJugador = asistencia.nombreJugador
        .toUpperCase()
        .includes(filtro.toUpperCase());
      return contieneJugador;
    }))  as Observable<Asistencia[]>;
  }

  getAsistenciasPorTipo(valor) {
    return of(
      this.asistencias.filter((asistencia) => {
        return asistencia.tipoAsistencia.toUpperCase().includes(valor.toUpperCase());
      })
    )  as Observable<Asistencia[]>;
  }

  getAsistenciasPorEquipo(equipo) {
    return of(
      this.asistencias.filter((asistencia) => {
        return asistencia.equipoJugador.nombre.toUpperCase().includes(equipo.toUpperCase());
      })
    )  as Observable<Asistencia[]>;
  }
  getAsistenciasPorFecha(fecha: any) {
    return of(
      this.asistencias.filter((asistencia)=>{
        return asistencia.fecha.includes(fecha);
      })
    )  as Observable<Asistencia[]>;
  }
  getAsistenciasEntreFechas(fechaIni: any, fechaFin: any) {
    return of(
      this.asistencias.filter((asistencia)=>{
        return asistencia.fecha >= fechaIni && asistencia.fecha <= fechaFin;
      })
    )  as Observable<Asistencia[]>;
  }
  getAsistenciasPorEquipoYTipo(equipo, valor) {
    return of(
      this.asistencias.filter((asistencia) => {
        return (
          this.getAsistenciasPorEquipo(equipo) && this.getAsistenciasPorTipo(valor)
        );
      })
    ) as Observable<Asistencia[]>;
  }

  getAsistenciaPorId(id: string) {
    return of(this.asistencias[id]) as Observable<Asistencia>;
  }

  getIdAsistencia(asistencia):any {
    return this.asistencias.indexOf(asistencia);
  }

  getAsistenciasJugador(jugador: Jugador): Observable<Asistencia[]> {
    let hrefJugador = jugador._links.self.href;
    return of(this.asistencias.filter(
      asistencia => {
        asistencia._links.jugador.href == hrefJugador;
      }
    )) as Observable<Asistencia[]>;
  }

  crearAsistencia(asistencia: Asistencia) {
    this.asistencias.push(asistencia);
    return of(null);
  }

  modificarAsistencia(id: string, asistencia: Asistencia) {
    this.asistencias[id] = asistencia;
    return of(null);
  }

  borrarAsistencia(id: any): Observable<Object> {
    this.asistencias.splice(id,1);
    return of(null);
  }
}
