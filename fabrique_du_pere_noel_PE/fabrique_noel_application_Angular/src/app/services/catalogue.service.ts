import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Catalogue } from 'src/app/models/catalogue.model';
import {Observable} from 'rxjs/Observable';
import { MatDialog } from '@angular/material/dialog'
@Injectable({
  providedIn: 'root'
})
export class CatalogueService {


  private URL = "http://localhost:8080/catalogues";

  constructor(private httpClient: HttpClient,private dialog: MatDialog) { }

  public getCatalogueList(): Observable<Catalogue>{
    return this.httpClient.get<Catalogue>(this.URL);
  }

  public deleteCatalogue(id:number){
    return this.httpClient.get(this.URL+"/deleteCatalogue/"+id);

  }
  edit(catalogue:Catalogue): Observable<Catalogue> {
    return this.httpClient.put<Catalogue>(this.URL + "/updateCatalogue/",catalogue);
  }


  
}
