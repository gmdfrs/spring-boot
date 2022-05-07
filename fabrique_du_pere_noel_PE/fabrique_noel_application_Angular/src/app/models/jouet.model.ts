import {Categorie} from './categorie.model';
import {Lutin} from './lutin.model';
import {Commande} from './commande.model';
import {Catalogue} from './catalogue.model';
import {Competence} from './competence.model';

export class Jouet{


  constructor(public nom: string, public lutin: Lutin,
              public categorie: Categorie, public commande: Commande,
              public catalogue: Catalogue, public competences: Competence[]){}
}
