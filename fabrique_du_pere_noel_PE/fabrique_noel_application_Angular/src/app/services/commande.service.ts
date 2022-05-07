import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CommandeService {

  private REST_API_SERVER = "http://localhost:3000/";

  constructor(private httpClient: HttpClient) { }

  public get(){
    return this.httpClient.get(this.REST_API_SERVER);
  }
}
