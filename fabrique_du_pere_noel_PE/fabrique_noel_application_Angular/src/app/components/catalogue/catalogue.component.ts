import { Component, OnInit ,Inject } from '@angular/core';
import { CatalogueService } from 'src/app/services/catalogue.service';
import { Catalogue } from 'src/app/models/catalogue.model';
import { MatTableDataSource } from '@angular/material/table';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
@Component({
  selector: 'app-catalogue',
  templateUrl: './catalogue.component.html',
  styleUrls: ['./catalogue.component.scss']
})

export class CatalogueComponent implements OnInit {

  
  constructor(private catalogueService: CatalogueService,public dialog: MatDialog, private _snackBar: MatSnackBar) { }
  //catalogues : Catalogue[]=[];
  displayedColumns: string[] = ['No', 'NOM','edit','delete'];
  dataSource :any;
  id: number=0;
  nomCat : string = "";
  catalogue: Catalogue[]=[];


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
  ngOnInit(): void {
    this.getCatalogues();
  }
  getCatalogues()
  {
    this.catalogueService.getCatalogueList().subscribe((data : any)=>{
      this.catalogue = data;
      this.dataSource = new MatTableDataSource(data);
      console.log(this.dataSource)
    })  
  }
  onDelete(id: number) {

  }
 
  EditopenDialog(x : Catalogue): void {
    this.id = x.id;
    this.nomCat = x.nom;
    const dialogRef = this.dialog.open(CatalogueModifierComponent, {
      width: '250px',
      data: {id: this.id, nom: this.nomCat}
    });

    dialogRef.afterClosed().subscribe(result => {
      x.nom= result;
      this.catalogueService.edit(x).subscribe(response => {
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
}
@Component({
  selector: 'catalogue-modifier',
  templateUrl: './catalogue-modifier.component.html',
})
export class CatalogueModifierComponent {

  constructor(
    public dialogRef: MatDialogRef<CatalogueModifierComponent>,
    @Inject(MAT_DIALOG_DATA) public data: Catalogue) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}