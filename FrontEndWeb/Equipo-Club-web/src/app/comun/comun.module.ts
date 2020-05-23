import { FormsModule } from '@angular/forms';
import { ServiciosModule } from './../servicios/servicios.module';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CabeceraComponent } from './cabecera/cabecera.component';
import { PieComponent } from './pie/pie.component';
import { HomeComponent } from './home/home.component';
import { SinFuncionComponent } from './sin-funcion/sin-funcion.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { MatIconModule } from '@angular/material/icon';


@NgModule({
  declarations: [
    CabeceraComponent,
    PieComponent,
    HomeComponent,
    SinFuncionComponent,
  ],
  imports: [
    CommonModule,
    ServiciosModule,
    MatIconModule,
    RouterModule,
    FormsModule,
    FontAwesomeModule
  ],
  exports: [
    CabeceraComponent,
    PieComponent,
    HomeComponent,
    SinFuncionComponent,
    MatIconModule,
    FormsModule,
    FontAwesomeModule
  ],
})
export class ComunModule {}
