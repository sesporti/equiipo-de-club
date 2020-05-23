import { TestBed } from '@angular/core/testing';

import { AsistenciasApiService } from './asistencias-api.service';

describe('AsistenciasApiService', () => {
  let service: AsistenciasApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AsistenciasApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
