import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuAsistenciaComponent } from './menu-asistencia.component';

describe('MenuAsistenciaComponent', () => {
  let component: MenuAsistenciaComponent;
  let fixture: ComponentFixture<MenuAsistenciaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuAsistenciaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuAsistenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
