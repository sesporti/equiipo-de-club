import { AppInfoService } from './../../servicios/app-info.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cabecera',
  templateUrl: './cabecera.component.html',
  styleUrls: ['./cabecera.component.css']
})
export class CabeceraComponent implements OnInit {

  nombreApp: string;

  constructor(private appInfoService: AppInfoService) { }

  ngOnInit(): void {
    this.nombreApp = this.appInfoService.getNombreApp();
  }

}
