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
import {SignupComponent} from './components/auth/signup/signup.component';
import {Routes} from '@angular/router';
import {RouterModule} from '@angular/router';
import { HeaderComponent } from './components/header/header.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatButtonModule} from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { HomeComponent } from './components/home/home.component';
const appRoutes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'auth/signin' },
  {path : 'auth/signup', component : SignupComponent},
  {path : 'auth/signin', component : SigninComponent}
  ];

@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    SigninComponent,
    HeaderComponent,
    HomeComponent
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
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }

