import { TestBed } from '@angular/core/testing';

import { LutinService } from './lutin.service';

describe('LutinService', () => {
  let service: LutinService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LutinService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
