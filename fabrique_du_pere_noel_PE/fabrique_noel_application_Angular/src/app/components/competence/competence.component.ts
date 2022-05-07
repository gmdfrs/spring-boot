import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { ICompetence } from 'src/app/models/competence.model';
import { CompetenceService } from 'src/app/services/competence.service';

@Component({
  selector: 'app-competence',
  templateUrl: './competence.component.html',
  styleUrls: ['./competence.component.scss']
})
export class CompetenceComponent implements OnInit {

  constructor(private competenceService: CompetenceService,public dialog: MatDialog, private _snackBar: MatSnackBar) { }
  competence : ICompetence[]=[];
  displayedColumns: string[] = ['No', 'NOM' ,'MODIFIER' ,'SUPPRIMER'];
  dataSource :any;
  nomComp : string = "";
  idComp : number = 0;
  closed : boolean = false;

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  ngOnInit(): void {
    this.competenceService.get().subscribe((data : any)=>{
      this.competence = data;
      this.dataSource = new MatTableDataSource(this.competence);
      //console.log(this.dataSource)
    })  
  }

  openDialog(x : ICompetence): void {
    this.idComp = x.id;
    this.nomComp = x.nom;
    const dialogRef = this.dialog.open(CompetenceModifierComponent, {
      width: '250px',
      data: {id: this.idComp, nom: this.nomComp}
    });

    dialogRef.afterClosed().subscribe(result => {
      x.nom= result;
      this.competenceService.update(x).subscribe(response => {
      });
      this.openSnackBar("Compétence bien modifié","")
      console.log('The dialog was closed');
    });
  }

  openSnackBar(message: string, action: string) {
    this._snackBar.open(message, action, {
      duration: 2000,
    });
  }

  delete(x : ICompetence){
    this.competenceService.delete(x.id).subscribe(response => {
      this.openSnackBar("Compétence bien supprimé","")
    });
  }

}



@Component({
  selector: 'competence-modifier',
  templateUrl: 'competence-modifier.component.html',
})
export class CompetenceModifierComponent {

  constructor(
    public dialogRef: MatDialogRef<CompetenceModifierComponent>,
    @Inject(MAT_DIALOG_DATA) public data: ICompetence) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}