import { Injectable } from '@angular/core';
import { Library } from '../model/library.model';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Observable, BehaviorSubject, of } from 'rxjs';
import { User } from '../model/user.model';
import { Movie } from '../model/movie.model';  
import { map } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
  })
  export class LibraryService {

    private availableLibraries: Library[] = [];
    availableLibraries$: BehaviorSubject<Library[]> = new BehaviorSubject(this.availableLibraries);



    newLibrary :Library = new Library;
    libraryList: Library[] = [];
    user: User;
    moviesList: Movie[];

  
    constructor(private httpClient: HttpClient) { 
  
    }

    public getAllLibraries(): Observable<Library[]> {
        return this.httpClient.get<Library[]>(environment.apiUrl + 'libraries');
    }

    // public findLibrary(libraryId: number): Observable<Library> {
    //     if (libraryId) {
    //       if (!this.availableLibraries) {
    //         return this.getAllLibraries().pipe(map(libraries => libraries.find(library => library.libraryId === libraryId)));
    //       }
    //       return of(this.availableLibraries.find(library => library.libraryId === libraryId));
    //     } else {
    //       return of(new Library(null, "", this.user, this.moviesList));
    //     }
    //   }

    addLibrary(newLibrary: Library, username: String) {
        this.httpClient.post<Library>(environment.apiUrl + 'addLibrary/' + username, newLibrary).subscribe(
            newLibrary => {
                this.availableLibraries.push(newLibrary);
                this.availableLibraries$.next(this.availableLibraries);
                console.log("available : " + this.availableLibraries);
                console.log("available$ : " + this.availableLibraries$);
                
            }
        )
            }

    getOneLibrary(username: String): Observable<Library[]> {
        return this.httpClient.get<Library[]>(environment.apiUrl + 'libraries/user/' + username);
    }


    
    libraryDetail(libraryId: number): Observable<Library> {
        return this.httpClient.get<Library>(environment.apiUrl + 'libraries/' + libraryId);
    }

    public publishLibraries() {
        this.getAllLibraries().subscribe(
          libraries => {
            this.availableLibraries = libraries;
            this.availableLibraries$.next(this.availableLibraries);
          });
      }

      /**
   * Cette fonction permet de trouver un timeline dans la liste des timelines chargés par l'application
   * grâce à son ID.
   * @param libraryId l'id qu'il faut rechercher dans la liste. 
   */
  public findLibrary(libraryId: number): Observable<Library> {
    if (libraryId) {
      if (!this.availableLibraries) {
        return this.getAllLibraries().pipe(map(libraries => libraries.find(library => library.libraryId === libraryId)));
      }
      return of(this.availableLibraries.find(library => library.libraryId === libraryId));
    } else {
      return of(new Library(null, "", this.user, this.moviesList));
    }
  }
  }