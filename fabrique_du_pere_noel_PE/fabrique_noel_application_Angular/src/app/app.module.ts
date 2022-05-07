import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';


import {MaterialModule,} from './material.module';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatTableModule } from '@angular/material/table'

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FlexLayoutModule} from '@angular/flex-layout';
import {MatIconModule} from '@angular/material/icon';



import { SigninComponent } from './components/auth/signin/signin.component';
import { CommandeListComponent } from './components/commande-list/commande-list.component';
import { CommandeComponent } from './components/commande/commande.component';
import { CatalogueComponent ,CatalogueModifierComponent } from './components/catalogue/catalogue.component';
import {SignupComponent} from './components/auth/signup/signup.component';
import {Routes} from '@angular/router';
import {RouterModule} from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import { CompetenceComponent, CompetenceModifierComponent } from './components/competence/competence.component';
import {HttpClientModule} from '@angular/common/http';
import {CommandeFormComponent} from './components/commande-form/commande-form.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
const appRoutes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'auth/signin' },
  {path : 'auth/signup', component : SignupComponent},
  {path : 'auth/signin', component : SigninComponent},
  {path : 'commandes' , component : CommandeListComponent},
  {path : 'commande/new', component : CommandeComponent},
  {path : 'competence', component : CompetenceComponent},

  {path : 'commande/new', component : CommandeComponent},
  {path : 'catalogues', component : CatalogueComponent},
  {path : 'commande', component : CommandeComponent},
  {path : 'commande/new', component : CommandeFormComponent}
  ];

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    SigninComponent,
    CommandeListComponent,
    CatalogueComponent,
    CatalogueModifierComponent,
    CommandeComponent,
    HeaderComponent,
    CommandeFormComponent,
    CompetenceComponent,
    CompetenceModifierComponent,
    CommandeFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatButtonModule,
    MaterialModule,
    MatFormFieldModule,
    MatIconModule,
    BrowserAnimationsModule,
    FlexLayoutModule,
    MatDialogModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    FormsModule,
    HttpClientModule,
    MatFormFieldModule,
    MatTableModule,
    MatInputModule,
    RouterModule.forRoot(appRoutes),
    FormsModule,
    ReactiveFormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

