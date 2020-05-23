import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAsistenciaComponent } from './form-asistencia.component';

describe('FormAsistenciaComponent', () => {
  let component: FormAsistenciaComponent;
  let fixture: ComponentFixture<FormAsistenciaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormAsistenciaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormAsistenciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
