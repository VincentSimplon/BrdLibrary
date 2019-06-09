import { Component, OnInit } from '@angular/core';
import { LibraryService } from '../service/library.service';
import { Router } from '@angular/router';
import { Library } from '../model/library.model';
import { User } from '../model/user.model';
import { Movie } from '../model/movie.model';
import { LoginService } from '../service/login.service';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import * as jwt_decode from 'jwt-decode';

@Component({
  selector: 'app-add-library',
  templateUrl: './add-library.component.html',
  styleUrls: ['./add-library.component.css']
})
export class AddLibraryComponent implements OnInit {

  newLibrary: Library;
  username: String;
  user: User;
  movies: Movie[];


  constructor(private libraryService: LibraryService, private router: Router, private loginService: LoginService, private httpClient: HttpClient) { }

  ngOnInit() {

    // const decodedToken = jwt_decode(sessionStorage.getItem(environment.accessToken));
    // const username = decodedToken.username;
    
    
    this.newLibrary = new Library(null, "", this.getUsername(), this.movies);

  }

  getUsername() {

    if (sessionStorage.getItem(environment.accessToken)) {
      const decodedToken: any = jwt_decode(sessionStorage.getItem(environment.accessToken));
      const username = decodedToken.username;
      return username;
    }
  }

    
    addLibrary() {
      this.libraryService.addLibrary(this.newLibrary, this.getUsername());
      console.log(this.newLibrary)
      
    }

  }


