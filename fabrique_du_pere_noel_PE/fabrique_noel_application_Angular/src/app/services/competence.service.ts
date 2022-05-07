import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { ICompetence } from '../models/competence.model';


@Injectable({
  providedIn: 'root'
})
export class CompetenceService {



  private URL = "http://localhost:8080/competences";

  constructor(private httpClient: HttpClient) { }

  public get(): Observable<ICompetence> {
    return this.httpClient.get<ICompetence>(this.URL);
  }

  update(competence: ICompetence): Observable<ICompetence> {
    return this.httpClient.put<ICompetence>(this.URL + "/updateCompetence",competence);
  }

  delete(id: number): Observable<ICompetence> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.httpClient.delete<ICompetence>(this.URL + '/deleteCompetence/' + id, { headers: headers });
  }
}
