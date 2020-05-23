import { AsistenciasService } from 'src/app/servicios/asistencias.service';
import { Jugador } from './../../modelo/jugador';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Asistencia } from 'src/app/modelo/asistencia';
import { HttpErrorResponse } from '@angular/common/http';
import { JugadoresService } from 'src/app/servicios/jugadores.service';

const url_jugadores = 'https://equiipo-club-api.herokuapp.com/api/jugadores';

@Component({
  selector: 'app-form-asistencia',
  templateUrl: './form-asistencia.component.html',
  styleUrls: ['./form-asistencia.component.css'],
})
export class FormAsistenciaComponent implements OnInit {
  titulo: string;
  asistencia: Asistencia;
  fechaMinima: Date;
  jugadores: Jugador[];
  tipos = ['SI', 'ENFERMEDAD', 'ESTUDIOS', 'LESION', 'INDEFINIDO'];
  idJugador: string;

  constructor(
    private asistenciasService: AsistenciasService,
    public jugadoresService: JugadoresService,
    private router: Router,
    private ruta: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.asistencia = {
      fecha: '',
      tipoAsistencia: '',
      nombreJugador: '',
      equipoJugador: {
        nombre: '',
        licencia: '',
        categoria: '',
      },
      _links: {
        self: {
          href: '',
        },
        asistencia: {
          href: '',
        },
        jugador: {
          href: '',
        },
      },
      jugador: '',
    };

    this.jugadoresService
      .getJugadores()
      .subscribe((respuesta) => (this.jugadores = respuesta));

    this.idJugador = '';

    let id = this.ruta.snapshot.paramMap.get('id');

    if (id) {
      this.asistenciasService
        .getAsistenciaPorId(id)
        .subscribe((respuesta: any) => {
          this.asistencia = respuesta;
        });
      this.titulo = 'EDITAR ASISTENCIA';
      this.fechaMinima = new Date('01/01/1970');
    } else {
      this.titulo = 'REGISTRAR NUEVA ASISTENCIA A JUGADOR';
      this.fechaMinima = new Date();
    }
  }

  obtenerNombreJugador(id) {
    this.jugadoresService.getJugadorPorId(id).subscribe((respuesta) => {
      this.asistencia.nombreJugador = respuesta.nombre;
    });
  }

  guardar(f: NgForm) {
    let id = this.ruta.snapshot.paramMap.get('id');

    this.asistencia.jugador = `${url_jugadores}/${this.idJugador}`;

    if (id) {
      this.asistenciasService
        .modificarAsistencia(id, this.asistencia)
        .subscribe(() => this.router.navigate(['/asistencias']));
    } else {
      this.asistenciasService
        .crearAsistencia(this.asistencia)
        .subscribe(() => this.router.navigate(['/asistencias']));
      (error: HttpErrorResponse) => {
        alert(
          'Mensaje desde el suscriptor: Se ha producido un error inesperado al crear el partido: \n\n' +
            error.message
        );
      };
    }
  }

  cancelar(f: NgForm) {
    if (f.dirty) {
      if (
        confirm('Las cambios realizados se perderán. ¿Desea continuar?') ==
        false
      ) {
        return;
      }
    }
    this.router.navigate(['/asistencias']);
  }
}
