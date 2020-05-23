import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { AsistenciasService } from 'src/app/servicios/asistencias.service';
import { faCalendarAlt as farCalendarAlt } from '@fortawesome/free-regular-svg-icons';
import {
  faEdit as fasEdit,
  faTrashAlt as fasTrashAlt,
} from '@fortawesome/free-solid-svg-icons';
import { Asistencia } from 'src/app/modelo/asistencia';

@Component({
  selector: 'app-lista-asistencia',
  templateUrl: './lista-asistencia.component.html',
  styleUrls: ['./lista-asistencia.component.css'],
})
export class ListaAsistenciaComponent implements OnInit {
  idAsistencia: string;
  asistenciasLista: Asistencia[] = [];
  filtroActivo;
  fechaInicialBuscada;
  fechaFinalBuscada;

  farCalendarAlt = farCalendarAlt;
  fasEdit = fasEdit;
  fasTrashAlt = fasTrashAlt;

  constructor(
    public asistenciasService: AsistenciasService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.asistenciasService
      .getAsistencias()
      .subscribe((respuesta) => (this.asistenciasLista = respuesta));
    this.filtroActivo = false;
    this.fechaInicialBuscada = '';
    this.fechaFinalBuscada = '';
    this.idAsistencia = '';
  }

  estaPresente(asistencia) {
    return asistencia.tipoAsistencia == 'SI';
  }

  filtrarJugador(filtro) {
    if (!filtro || filtro.trim().length == 0) {
      this.filtroActivo = false;
      this.asistenciasService
        .getAsistencias()
        .subscribe((respuesta) => (this.asistenciasLista = respuesta));
    } else {
      this.filtroActivo = true;
      this.asistenciasService
        .getAsistenciasConJugador(filtro)
        .subscribe((respuesta) => (this.asistenciasLista = respuesta));
    }
  }

  filtrarAsistencia(valor) {
    if (!valor || valor.trim().length == 0) {
      this.asistenciasService
        .getAsistencias()
        .subscribe((respuesta) => (this.asistenciasLista = respuesta));
      this.filtroActivo = false;
    } else {
      this.asistenciasService
        .getAsistenciasPorTipo(valor)
        .subscribe((respuesta) => (this.asistenciasLista = respuesta));
      this.filtroActivo = true;
    }
  }

  filtrarEquipo(equipo) {
    if (!equipo || equipo.trim().length == 0) {
      this.asistenciasService
        .getAsistencias()
        .subscribe((respuesta) => (this.asistenciasLista = respuesta));
      this.filtroActivo = false;
    } else {
      this.asistenciasService
        .getAsistenciasPorEquipo(equipo)
        .subscribe((respuesta) => (this.asistenciasLista = respuesta));
      this.filtroActivo = true;
    }
  }

  filtrarPorFecha(fecha) {
    if (!fecha) {
      this.asistenciasService
        .getAsistencias()
        .subscribe((respuesta) => (this.asistenciasLista = respuesta));
      this.filtroActivo = false;
    } else {
      this.asistenciasService
        .getAsistenciasPorFecha(this.cambiarFormatoFecha(fecha))
        .subscribe((respuesta) => (this.asistenciasLista = respuesta));
      this.filtroActivo = true;
    }
  }

  cambiarFormatoFecha(fecha) {
    let fecha1 = fecha.toString();
    let dia = fecha1.substr(8, 2);
    let mes = fecha1.substr(5, 2);
    let anio = fecha1.substr(2, 2);
    let fechaCambiada = dia + '/' + mes + '/' + anio;
    return fechaCambiada;
  }

  filtrarEntreFechas(fechaIni, fechaFin) {
    this.asistenciasService
      .getAsistenciasEntreFechas(
        this.cambiarFormatoFecha(fechaIni),
        this.cambiarFormatoFecha(fechaFin)
      )
      .subscribe((respuesta) => (this.asistenciasLista = respuesta));
    this.filtroActivo = true;
  }

  filtrarPorEquipoYTipo(equipo, valor) {
    this.filtroActivo = true;
    this.asistenciasService
      .getAsistenciasPorEquipoYTipo(equipo, valor)
      .subscribe((respuesta) => (this.asistenciasLista = respuesta));
  }
  borrarFiltros() {
    this.filtrarJugador('');
    this.filtrarAsistencia('');
    this.filtrarEquipo('');
    this.filtroActivo = false;
  }
  borrarAsistencia(asistencia) {
    this.idAsistencia = this.asistenciasService.getIdAsistencia(asistencia);
    console.log(this.idAsistencia);

    if (confirm('¿Desea borrar este registro de asistencia?')) {
      this.asistenciasService
        .borrarAsistencia(this.idAsistencia)
        .subscribe(() => {
          this.asistenciasService
            .getAsistencias()
            .subscribe((respuesta) => (this.asistenciasLista = respuesta));
          this.router.navigate(['/asistencias']);
        });
    }
  }
}
