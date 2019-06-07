import { Injectable } from '@angular/core';
import { User } from '../model/user.model';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { map } from 'rxjs/operators';
import { environment } from '../../environments/environment';

@Injectable({
    providedIn: 'root'
  })
  export class UserService {

    newUser = User;
    userList: User[] = [];

  
    constructor(private httpClient: HttpClient) { 
  
    }

    addUser(newUser: User) {
        this.httpClient.post<User>(environment.apiUrl + 'addUser', newUser).subscribe(
            newUser => {
                this.userList.push(newUser);
                
            }
        )
            }

    getAllUsers(): Observable<User[]> {
        return this.httpClient.get<User[]>(environment.apiUrl + 'users');
    }

    
    UpdateUser(user: User) {
        return this.httpClient.put<User>(environment.apiUrl + 'profil/update', user);
    }

        
    }


  