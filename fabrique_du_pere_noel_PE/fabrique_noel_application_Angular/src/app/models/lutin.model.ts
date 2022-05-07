import { Commande } from "./commande.model";
import { Competence } from "./competence.model";

export class Lutin {
  disposable: boolean = false;
  commande: Commande = new Commande();
  competences: Competence[]=[];

  constructor() {
  }
}

