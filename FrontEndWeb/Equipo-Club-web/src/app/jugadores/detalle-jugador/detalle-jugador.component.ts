import { AsistenciasService } from 'src/app/servicios/asistencias.service';
import { Asistencia } from './../../modelo/asistencia';
import { EquiposService } from 'src/app/servicios/equipos.service';
import { ActivatedRoute, Router } from '@angular/router';
import { JugadoresService } from 'src/app/servicios/jugadores.service';
import { Jugador } from 'src/app/modelo/jugador';
import { Component, OnInit } from '@angular/core';
import { faChevronCircleLeft as fasChevronCircleLeft } from '@fortawesome/free-solid-svg-icons';
import { FavoritoEvent } from 'src/app/componentes/favorito/favorito-event';
import { Equipo } from 'src/app/modelo/equipo';

@Component({
  selector: 'app-detalle-jugador',
  templateUrl: './detalle-jugador.component.html',
  styleUrls: ['./detalle-jugador.component.css'],
})
export class DetalleJugadorComponent implements OnInit {
  fasChevronCircleLeft = fasChevronCircleLeft;

  idJugador;
  jugador: Jugador = {
    nombre: '',
    edad: 0,
    fechaNacimiento: '',
    poc: '',
    nif: '',
    _links: {
      self: {
        href: '',
      },
      jugador: {
        href: '',
      },
      asistencias: {
        href: '',
      },
      equipo: {
        href: '',
      },
    },
    equipo: '',
    nombreEquipo: '',
  };
  asistencias: Asistencia[] = [];
  equipo: Equipo = null;

  constructor(
    public jugadoresService: JugadoresService,
    private equiposService: EquiposService,
    private asistenciasService: AsistenciasService,
    private ruta: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.idJugador = this.ruta.snapshot.paramMap.get('id');

    this.jugadoresService
      .getJugadorPorId(this.idJugador)
      .subscribe((respuesta) => {
        this.jugador = respuesta;

        this.equiposService
          .getEquipoPorJugadorNombre(this.jugador.nombre)
          .subscribe((respuesta) => (this.equipo = respuesta));

        this.asistenciasService
          .getAsistenciasJugador(this.jugador)
          .subscribe((respuesta) => (this.asistencias = respuesta));
      });
  }

  borrarJugador() {
    if (confirm('¿Desea borrar el jugador?')) {
      this.jugadoresService
        .borrarJugador(this.idJugador)
        .subscribe(() => this.router.navigate(['/jugadores']));
    }
  }

  cambiaJugadorFavorito(evento: FavoritoEvent) {
    console.log(
      `Valor ${evento.valor} ${evento.esFavorito ? 'es' : 'no es'} favorito`
    );
  }
}
