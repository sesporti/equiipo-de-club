import { TestBed } from '@angular/core/testing';

import { EquiposApiService } from './equipos-api.service';

describe('EquiposApiService', () => {
  let service: EquiposApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EquiposApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
