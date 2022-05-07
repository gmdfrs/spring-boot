import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { TokenStorageService } from '../services/token-storage.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.scss']
})
export class SigninComponent implements OnInit {
  form: any = {};
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  constructor(private authService: AuthService, private tokenStorage: TokenStorageService) { }
  
  ngOnInit() {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

 // onSubmit() {
   /* this.authService.login(this.form).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        this.reloadPage();
      },*/
      /*err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }*/
    );*/
 // }

  reloadPage() {
    window.location.reload();
  }
}

// https://bezkoder.com/spring-boot-jwt-authentication/
// https://bezkoder.com/angular-jwt-authentication/
// https://manage.auth0.com/dashboard/eu/dev-gx843fe2/apis/60aa46b5ee0487003e7550d7/test
// https://devstory.net/11677/securiser-spring-boot-restful-service-en-utilisant-auth0-jwt