import { TestBed } from '@angular/core/testing';

import { JouetService } from './jouet.service';

describe('JouetService', () => {
  let service: JouetService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JouetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
