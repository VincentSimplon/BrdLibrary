import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';
import { User } from '../model/user.model';
import { LoginService } from '../service/login.service';
import { LoginComponent } from '../login/login.component';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  user: User;
  username: String;
  
  constructor(private httpClient: HttpClient, private loginService: LoginService) { }
  
  
  
  ngOnInit() {
    
    this.loginService.usernameSubject.subscribe(
      (res) => {this.username = res
        this.httpClient.get<User>(environment.apiUrl + 'profil/' + this.username).subscribe(
          res => {
            this.user = res
          }
        )
    }
       
    )

    
      
  }

}
