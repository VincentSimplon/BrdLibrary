import { Component, OnInit } from '@angular/core';
import { Library } from '../model/library.model';
import { LibraryService } from '../service/library.service';
import { LoginService } from '../service/login.service';
import { User } from '../model/user.model';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-libraries-list',
  templateUrl: './libraries-list.component.html',
  styleUrls: ['./libraries-list.component.css']
})
export class LibrariesListComponent implements OnInit {

  librariesList: Library[] = [];
  library: Library;
  username: string;
  user: User = new User;

  constructor(private libraryService: LibraryService, private loginService: LoginService, private httpClient: HttpClient) { }

  ngOnInit() {
    this.libraryService.getOneLibrary(this.loginService.getUsername()).subscribe(libraries => this.librariesList = libraries);
  }

}