import { Component, OnInit } from '@angular/core';
import {faUserPlus as fasUserPlus } from '@fortawesome/free-solid-svg-icons'

@Component({
  selector: 'app-menu-jugador',
  templateUrl: './menu-jugador.component.html',
  styleUrls: ['./menu-jugador.component.css']
})
export class MenuJugadorComponent implements OnInit {

  titulo: string = 'Gestión de Jugadores';
  fasUserPlus = fasUserPlus;
  
  constructor() { }

  ngOnInit(): void {
  }

}
