import { ComponentesModule } from './../componentes/componentes.module';
import { RouterModule } from '@angular/router';
import { ComunModule } from './../comun/comun.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormJugadorComponent } from './form-jugador/form-jugador.component';
import { ListaJugadorComponent } from './lista-jugador/lista-jugador.component';
import { DetalleJugadorComponent } from './detalle-jugador/detalle-jugador.component';
import { HomeJugadorComponent } from './home-jugador/home-jugador.component';
import { MenuJugadorComponent } from './menu-jugador/menu-jugador.component';

@NgModule({
  declarations: [
    FormJugadorComponent,
    ListaJugadorComponent,
    DetalleJugadorComponent,
    HomeJugadorComponent,
    MenuJugadorComponent,
  ],
  imports: [
    CommonModule,
    ComunModule,
    ComponentesModule,
    RouterModule.forChild([
      {
        path: 'jugadores',
        component: HomeJugadorComponent,
        children: [
          { path: '', component: ListaJugadorComponent },
          { path: 'form/:id', component: FormJugadorComponent },
          { path: 'form', component: FormJugadorComponent },
          { path: ':id', component: DetalleJugadorComponent },
        ],
      },
    ]),
  ],
  exports: [ListaJugadorComponent],
})
export class JugadoresModule {}
