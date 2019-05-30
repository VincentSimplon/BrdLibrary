import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from '../model/user.model';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';
import { JsonWebToken } from '../model/jwt.model';
import * as jwt_decode from 'jwt-decode'
import { tokenName } from '@angular/compiler';




@Injectable({
    providedIn: 'root'
  })
  export class LoginService {
  
    userRoles: BehaviorSubject<string[]> = new BehaviorSubject([]);

    constructor(private httpClient: HttpClient, private router: Router) {
      this.getUserRoles();
      
    }

    public usernameSubject: BehaviorSubject<string> = new BehaviorSubject(null);  
    public setUsernameSubject(value: string){     
      if(value){       
        this.usernameSubject.next(value);     
      } else {       
        this.usernameSubject.next(null);     
      }   }
  
    public get loggedIn(): boolean {
      return sessionStorage.getItem(environment.accessToken) !== null;
    }
  
    login(user: User) {
      this.httpClient.post<JsonWebToken>(environment.apiUrl + 'login', user).subscribe(
        token => {
          sessionStorage.setItem(environment.accessToken, token.token);
          console.log("Julien : " + token.token)
          this.setUsernameSubject(user.username);
          this.getUserRoles();
          this.router.navigate(['']);
        },
        error => console.log('Error while login'));
    }
  
    logOut() {
      sessionStorage.removeItem(environment.accessToken);
    }
  
    private getUserRoles() {
        if (sessionStorage.getItem(environment.accessToken)) {
          const decodedToken: any = jwt_decode(sessionStorage.getItem(environment.accessToken));
          const authorities: Array<any> = decodedToken.auth;
          this.userRoles.next(authorities.map(authority => authority.authority));
          const username: String = decodedToken.username;
          console.log("decodedtoken = " + decodedToken);
          console.log("username = " + username)
        }
    }

   

    getUser(username: String) {
      return this.httpClient.get<User>(environment.apiUrl + 'profil/' + username).subscribe(
        res => console.log(res)
      )
  }
  }
  