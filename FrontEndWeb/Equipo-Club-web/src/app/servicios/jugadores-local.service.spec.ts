import { TestBed } from '@angular/core/testing';

import { JugadoresLocalService } from './jugadores-local.service';

describe('JugadoresLocalService', () => {
  let service: JugadoresLocalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JugadoresLocalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
