import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SinFuncionComponent } from './sin-funcion.component';

describe('SinFuncionComponent', () => {
  let component: SinFuncionComponent;
  let fixture: ComponentFixture<SinFuncionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SinFuncionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SinFuncionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
