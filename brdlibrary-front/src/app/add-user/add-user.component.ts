import { Component, OnInit } from '@angular/core';
import { DataService } from '../service/data.service';
import { User } from '../model/user.model';
import { UserService } from '../service/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  newUser: User;
  
  constructor(private userService: UserService,
              private router: Router) { }

  ngOnInit() {

    this.newUser = new User('', '', '', '', '', '', '', '', '', '', '', []);
  
  }

  addUser() {
    this.userService.addUser(this.newUser);
      

    
  }
}
