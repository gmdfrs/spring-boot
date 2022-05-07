import { Component, OnInit } from '@angular/core';
import {JouetService} from '../../services/jouet.service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Commande} from '../../models/commande.model';
import { Jouet } from 'src/app/models/jouet.model';
import { LutinService } from 'src/app/services/lutin.service';

@Component({
  selector: 'app-commande-form',
  templateUrl: './commande-form.component.html',
  styleUrls: ['./commande-form.component.scss']
})
export class CommandeFormComponent implements OnInit {

  commande: Commande = new Commande();
  formGroup: FormGroup | undefined ;
  jouets: any;
  lutins: any;

  constructor(private jouetService: JouetService, private formBuilder: FormBuilder, private lutinService: LutinService) {
  }

  ngOnInit(): void {
    this.listJouet();
    this.listLutin();
  }
  // tslint:disable-next-line:typedef
  createForm(){
    this.formGroup = this.formBuilder.group({
      dDebut: [null, Validators.required],
      dFint: [null, Validators.required],
      jouet: [null, Validators.required],
      lutin: [null, Validators.required]
    });
  }
  // tslint:disable-next-line:typedef
  public listJouet(){
    this.jouets = this.jouetService.getAllJouet().subscribe(
      data => {
        console.log(data);
        const items =<any[]>data;
        items.forEach(item => item.nom =item.nom);
        console.log("itemes " , items);
        return items;
      });
      console.log("this. jouets ",this.jouets);
    
  }
  public listLutin(){
    this.lutins = this.lutinService.getAllLutin().subscribe(
      data => {
        console.log(data);
        const items =<any[]>data;
        items.forEach(item => item.nom =item.nom);
        console.log("itemes " , items);
        return items;
      });
      console.log("this. lutin ",this.lutins);
      

  }
}
