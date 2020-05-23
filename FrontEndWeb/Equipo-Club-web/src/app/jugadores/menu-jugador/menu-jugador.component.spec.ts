import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuJugadorComponent } from './menu-jugador.component';

describe('MenuJugadorComponent', () => {
  let component: MenuJugadorComponent;
  let fixture: ComponentFixture<MenuJugadorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuJugadorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuJugadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
