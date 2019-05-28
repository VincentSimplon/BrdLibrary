import { Component, OnInit } from '@angular/core';
import { LoginService } from '../service/login.service';
import { Observable } from 'rxjs';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { map } from 'rxjs/operators';
import { Router } from '@angular/router';


@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

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

  constructor(private breakpointObserver: BreakpointObserver, private loginService: LoginService, private router: Router) {

  }

  logOut() {
    this.loginService.logOut();
    this.router.navigate(['logout']);
  }

  ngOnInit() {
    this.loginService.userRoles.subscribe(userRoles => {
      this.isUser = userRoles.includes('ROLE_USER');
      this.isAdmin = userRoles.includes('ROLE_ADMIN');
    });
  }
  
}