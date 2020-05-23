import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeAsistenciaComponent } from './home-asistencia.component';

describe('HomeAsistenciaComponent', () => {
  let component: HomeAsistenciaComponent;
  let fixture: ComponentFixture<HomeAsistenciaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeAsistenciaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeAsistenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
