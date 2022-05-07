import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Jouet} from '../models/jouet.model';
import {UrlConfig} from '../config/url-config';


@Injectable({
  providedIn: 'root'
})
export class JouetService {
  jouetUrl = UrlConfig.API_URL + '/jouets';

  constructor(private http: HttpClient){}

  // tslint:disable-next-line:typedef
  getAllJouet(){
    return this.http.get<Jouet[]>(this.jouetUrl);
}



}
