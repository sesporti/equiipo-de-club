import { Component, OnInit } from '@angular/core';
import { faPencilRuler, faWrench } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-sin-funcion',
  templateUrl: './sin-funcion.component.html',
  styleUrls: ['./sin-funcion.component.css'],
})
export class SinFuncionComponent implements OnInit {
  faPencilRuler = faPencilRuler;
  faWrench = faWrench;

  constructor() {}

  ngOnInit(): void {}
}
