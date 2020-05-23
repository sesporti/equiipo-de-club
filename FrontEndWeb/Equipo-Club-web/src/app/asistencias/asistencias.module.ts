import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListaAsistenciaComponent } from './lista-asistencia/lista-asistencia.component';
import { ComunModule } from '../comun/comun.module';
import { HomeAsistenciaComponent } from './home-asistencia/home-asistencia.component';
import { MenuAsistenciaComponent } from './menu-asistencia/menu-asistencia.component';
import { FormAsistenciaComponent } from './form-asistencia/form-asistencia.component';

@NgModule({
  declarations: [ListaAsistenciaComponent, HomeAsistenciaComponent, MenuAsistenciaComponent, FormAsistenciaComponent],
  imports: [CommonModule, ComunModule, RouterModule.forChild([
    {
      path:'asistencias', component: HomeAsistenciaComponent,
      children:[
        {path:'', component: ListaAsistenciaComponent},
        {path: 'form/:id', component: FormAsistenciaComponent},
        {path: 'form', component:FormAsistenciaComponent}
        
      ]
    }
  ])
  ],
  exports: [ListaAsistenciaComponent],
})
export class AsistenciasModule {}
