import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
import { LoginService } from '../service/login.service'
import { User } from '../model/user.model';
import { BehaviorSubject } from 'rxjs';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
  })
  export class LoginComponent {
  
    loginForm = this.fb.group({
      username: [null, Validators.required],
      password: [null, Validators.compose([
        Validators.required, Validators.minLength(5), Validators.maxLength(255)])
      ]
    });

  
  
    constructor(private fb: FormBuilder, private loginService: LoginService) {}
  
    onSubmit() {
      const user = new User();
      user.username = this.loginForm.value.username;
      user.password = this.loginForm.value.password;
      this.loginService.login(user);
      
    }

    

    
  }
  