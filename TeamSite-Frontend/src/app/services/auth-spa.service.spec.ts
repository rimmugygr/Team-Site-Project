import { TestBed } from '@angular/core/testing';

import { AuthSPAService } from './auth-spa.service';

describe('AuthSPAService', () => {
  let service: AuthSPAService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthSPAService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
