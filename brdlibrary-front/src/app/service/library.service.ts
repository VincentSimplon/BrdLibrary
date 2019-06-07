import { Injectable } from '@angular/core';
import { Library } from '../model/library.model';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
  export class LibraryService {

    newLibrary = Library;
    libraryList: Library[] = [];

  
    constructor(private httpClient: HttpClient) { 
  
    }

    addLibrary(newLibrary: Library, username: String) {
        this.httpClient.post<Library>(environment.apiUrl + 'addLibrary/' + username, newLibrary).subscribe(
            newLibrary => {
                this.libraryList.push(newLibrary);
                
            }
        )
            }

    getOneLibrary(username: String): Observable<Library[]> {
        return this.httpClient.get<Library[]>(environment.apiUrl + 'libraries/user/' + username);
    }

  }