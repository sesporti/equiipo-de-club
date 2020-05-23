import { TestBed } from '@angular/core/testing';

import { AsistenciasLocalService } from './asistencias-local.service';

describe('AsistenciasLocalService', () => {
  let service: AsistenciasLocalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AsistenciasLocalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
