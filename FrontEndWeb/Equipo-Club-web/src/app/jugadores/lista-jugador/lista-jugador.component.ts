import { JugadoresService } from 'src/app/servicios/jugadores.service';
import { Component, OnInit } from '@angular/core';
import { Jugador } from 'src/app/modelo/jugador';
import { faRunning as fasRunning } from '@fortawesome/free-solid-svg-icons';
import { FavoritoEvent } from 'src/app/componentes/favorito/favorito-event';

@Component({
  selector: 'app-lista-jugador',
  templateUrl: './lista-jugador.component.html',
  styleUrls: ['./lista-jugador.component.css'],
})
export class ListaJugadorComponent implements OnInit {
  
  jugadoresLista: Jugador[] = [];
  filtroActivo: boolean;
  edad: number;
  edadMinima: number;
  edadMaxima: number;
  licencias = [
    'PROFESIONAL',
    'AFICIONADO',
    'JUVENIL',
    'CADETE',
    'INFANTIL',
    'ALEVIN',
    'BENJAMIN',
    'PREBENJAMIN',
    'DEBUTANTE',
    'SINLICENCIA',
  ];
  
  fasRunning = fasRunning;

  constructor(
    public jugadoresService: JugadoresService,
  ) {}

  ngOnInit(): void {
    this.jugadoresService.getJugadores().subscribe((respuesta) => {
      this.jugadoresLista = respuesta;
    });

    this.filtroActivo = false;
    this.edad = 0;
    this.edadMaxima = 0;
    this.edadMinima = 0;
  }

  filtrarJugador(filtro) {
    if (!filtro || filtro.trim().length == 0) {
      this.filtroActivo = false;
      this.jugadoresService
        .getJugadores()
        .subscribe((respuesta) => (this.jugadoresLista = respuesta));
    } else {
      this.filtroActivo = true;
      this.jugadoresService
        .getJugadoresPorNombre(filtro)
        .subscribe((respuesta) => (this.jugadoresLista = respuesta));
    }
  }

  filtrarPorEdad(edad) {
    if (!edad || edad == 0 || edad.trim().length == 0) {
      this.filtroActivo = false;
      this.jugadoresService
        .getJugadores()
        .subscribe((respuesta) => (this.jugadoresLista = respuesta));
    } else {
      this.filtroActivo = true;
      this.jugadoresService
        .getJugadoresPorEdad(edad)
        .subscribe((respuesta) => (this.jugadoresLista = respuesta));
    }
  }

  filtrarPorLicencia(licencia) {
    if (!licencia || licencia.trim().length == 0) {
      this.filtroActivo = false;
      this.jugadoresService
        .getJugadores()
        .subscribe((respuesta) => (this.jugadoresLista = respuesta));
    } else {
      this.filtroActivo = true;
      this.jugadoresService
        .getJugadoresPorLicencia(licencia)
        .subscribe((respuesta) => (this.jugadoresLista = respuesta));
    }
  }

  filtrarPorEdades(edadMin, edadMax) {
    if (!edadMin || !edadMax || edadMin == 0 || edadMax == 0 || edadMin.trim().length == 0 || edadMax.trim().length == 0) {
      this.filtroActivo = false;
      this.jugadoresService
        .getJugadores()
        .subscribe((respuesta) => (this.jugadoresLista = respuesta));
    } else {
      this.filtroActivo = true;
      this.jugadoresService
        .getJugadoresPorEdadesLicencia(edadMin, edadMax)
        .subscribe((respuesta) => (this.jugadoresLista = respuesta));
    }
  }
  borrarFiltros() {
    
    this.filtrarJugador('');
    this.filtrarPorEdad('');
    this.filtrarPorEdades('','');
    this.filtrarPorLicencia('');    
    this.filtroActivo = false;
  }

  cambiaJugadorFavorito(evento: FavoritoEvent) {
    console.log(
      `Valor ${evento.valor} ${evento.esFavorito ? 'es' : 'no es'} favorito`
    );
  }
}
