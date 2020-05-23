import { Component, OnInit } from '@angular/core';
import { faCalendarPlus as farCalendarPlus } from '@fortawesome/free-regular-svg-icons';

@Component({
  selector: 'app-menu-asistencia',
  templateUrl: './menu-asistencia.component.html',
  styleUrls: ['./menu-asistencia.component.css'],
})
export class MenuAsistenciaComponent implements OnInit {
  titulo: string = 'Gestión Control de Asistencias';

  farCalendarPlus = farCalendarPlus;

  constructor() {}

  ngOnInit(): void {}
}
