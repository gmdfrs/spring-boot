import { Component, OnInit } from '@angular/core';
import { CommandeService } from 'src/app/services/commande.service';
import {JouetService} from '../../services/jouet.service';
import {Jouet} from '../../models/jouet.model';
import {Observable} from 'rxjs';
@Component({
  selector: 'app-commande',
  templateUrl: './commande.component.html',
  styleUrls: ['./commande.component.scss']
})
export class CommandeComponent implements OnInit {
 jouets: Observable<Jouet[]> = new Observable<Jouet[]>();


  constructor(private jouetService: JouetService) { }

  ngOnInit(): void {
    console.log('les commandes');
    this.listJouet();
  }
  // tslint:disable-next-line:typedef
  public listJouet(){
    this.jouets = this.jouetService.getAllJouet();
    console.log(this.jouetService.getAllJouet().subscribe(
      data => {
        console.log(data);
      }));
  }

}
