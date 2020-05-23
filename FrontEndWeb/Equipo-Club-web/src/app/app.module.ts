import localeEs from '@angular/common/locales/es';
import { SinFuncionComponent } from './comun/sin-funcion/sin-funcion.component';
import { RouterModule } from '@angular/router';
// import { AsistenciasLocalService } from './servicios/asistencias-local.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ErrorHandler, LOCALE_ID } from '@angular/core';
import { AppComponent } from './app.component';
import { AsistenciasModule } from './asistencias/asistencias.module';
import { ComunModule } from './comun/comun.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AsistenciasService } from './servicios/asistencias.service';
import { HomeComponent } from './comun/home/home.component';
import { AsistenciasApiService } from './servicios/asistencias-api.service';
import { JugadoresApiService } from './servicios/jugadores-api.service';
// import { ManejadorError } from './comun/manejador-error';
import { JugadoresService } from './servicios/jugadores.service';
import { registerLocaleData } from '@angular/common';
// import { JugadoresLocalService } from './servicios/jugadores-local.service';
import { EquiposApiService } from './servicios/equipos-api.service';
import { EquiposService } from './servicios/equipos.service';
import { JugadoresModule } from './jugadores/jugadores.module';


registerLocaleData(localeEs);


@NgModule({
  declarations: [AppComponent],
  imports: [
    BrowserModule,
    ComunModule,
    AsistenciasModule,
    JugadoresModule,
    BrowserAnimationsModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent },
      { path: 'jugadores', loadChildren: './jugadores/jugadores.module#JugadoresModule'},
      { path: 'entrenadores', component: SinFuncionComponent },
      { path: 'equipos', component: SinFuncionComponent },
      { path: 'asistencias', loadChildren: './asistencias/asistencias.module#AsistenciasModule' },
      { path: '**', component: SinFuncionComponent}
    ]),
  ],
  providers: [
    { provide: AsistenciasService, useClass: AsistenciasApiService },
    { provide: JugadoresService, useClass: JugadoresApiService },
    { provide: EquiposService, useClass: EquiposApiService },
    { provide: LOCALE_ID, useValue: 'es-ES' },
    // {provide: ErrorHandler, useClass: ManejadorError}
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}
