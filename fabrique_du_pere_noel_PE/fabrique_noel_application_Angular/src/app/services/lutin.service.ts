import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UrlConfig } from '../config/url-config';
import { Lutin } from '../models/lutin.model';

@Injectable({
  providedIn: 'root'
})
export class LutinService {
  lutinUrl = UrlConfig.API_URL + '/lutin';

  constructor(private http: HttpClient) { }
  getAllLutin(){
    return this.http.get<Lutin[]>(this.lutinUrl);
}
}
