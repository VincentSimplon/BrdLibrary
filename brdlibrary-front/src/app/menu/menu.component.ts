import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import { Observable } from 'rxjs';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';
import { ProfilComponent } from '../profil/profil.component';
import { User } from '../model/user.model';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';
import * as jwt_decode from 'jwt-decode';
import { getDefaultService } from 'selenium-webdriver/chrome';



@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  user: User;
  username: string;

  isUser: boolean;
  isAdmin: boolean;

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches)
    );

  nav_position: string = 'end';

  onTogglePosition(position: string) {
    this.nav_position = position === 'start' ? 'end' : 'start';
    
  }

  constructor(private breakpointObserver: BreakpointObserver, private loginService: LoginService, private router: Router, private httpClient: HttpClient) {

  }

  logOut() {
    this.loginService.logOut();
    this.isAdmin = false;
    this.isUser = false;
    
    
    
  }

  

  ngOnInit() {
    this.loginService.userRoles.subscribe(userRoles => {
      this.isUser = userRoles.includes('ROLE_USER');
      this.isAdmin = userRoles.includes('ROLE_ADMIN');
    
    });

      

    // this.loginService.getUserByUsername(this.getUsername());
    // console.log(this.loginService.getUserByUsername(this.getUsername()))

    // this.loginService.getUserByUsername(this.loginService.getUsername());
    
    


    this.loginService.usernameSubject.subscribe(
      (res) => {this.username = res
        this.httpClient.get<User>(environment.apiUrl + 'profil/' + this.username).subscribe(
          res => {
            this.user = res
          })
    })

    
    }
    
    
    
    // getUsername() {

    //   if (sessionStorage.getItem(environment.accessToken)) {
    //     const decodedToken: any = jwt_decode(sessionStorage.getItem(environment.accessToken));
    //     const username = decodedToken.username;
    //     return username;
    //   }
    // }

  
  
} 