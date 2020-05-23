import { Router, ActivatedRoute } from '@angular/router';
import { EquiposService } from 'src/app/servicios/equipos.service';
import { JugadoresService } from 'src/app/servicios/jugadores.service';
import { Equipo } from 'src/app/modelo/equipo';
import { Component, OnInit } from '@angular/core';
import { Jugador } from 'src/app/modelo/jugador';
import { NgForm } from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

const url_equipos = 'https://equiipo-club-api.herokuapp.com/api/equipos';

@Component({
  selector: 'app-form-jugador',
  templateUrl: './form-jugador.component.html',
  styleUrls: ['./form-jugador.component.css']
})
export class FormJugadorComponent implements OnInit {

  titulo: string;
  jugador: Jugador;
  equipos: Equipo[];
  idEquipo: string;
  fechaMaxima: Date;

  constructor(private jugadoresService: JugadoresService, public equiposService: EquiposService, private ruta: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {

    this.jugador = {
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
            href:
              '',
          },
          equipo: {
            href: '',
          },
      },
      equipo: '',
      nombreEquipo:''
    }

    this.idEquipo ='';
    this.fechaMaxima = new Date();

    this.equiposService.getEquipos().subscribe(respuesta => this.equipos = respuesta)

    let id = this.ruta.snapshot.paramMap.get('id');

    if (id) {
      this.jugadoresService
        .getJugadorPorId(id)
        .subscribe((respuesta: any) => {
          this.jugador = respuesta;
        });
      this.titulo = 'EDITAR JUGADOR';
    } else {
      this.titulo = 'REGISTRAR NUEVO JUGADOR';
    }

  }

  obtenerNombreEquipo(id){
    this.equiposService.getEquipoPorId(id).subscribe(respuesta => {this.jugador.nombreEquipo = respuesta.nombre})
  }

  guardar(f: NgForm) {
    
    let id = this.ruta.snapshot.paramMap.get('id');
   
    this.jugador.equipo = `${url_equipos}/${this.idEquipo}`;
   
    if (id) {
      this.jugadoresService
        .modificarJugador(id, this.jugador)
        .subscribe(() => this.router.navigate(['/jugadores']));
    } else {
      this.jugadoresService
        .crearJugador(this.jugador)
        .subscribe(() => this.router.navigate(['/jugadores']));
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
    this.router.navigate(['/jugadores']);
  }

}
