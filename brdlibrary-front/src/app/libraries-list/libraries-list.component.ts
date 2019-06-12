import { Component, OnInit } from '@angular/core';
import { Library } from '../model/library.model';
import { LibraryService } from '../service/library.service';
import { LoginService } from '../service/login.service';
import { User } from '../model/user.model';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';

@Component({
  selector: 'app-libraries-list',
  templateUrl: './libraries-list.component.html',
  styleUrls: ['./libraries-list.component.css']
})
export class LibrariesListComponent implements OnInit {

  librariesList: Library[];
  library: Library;
  username: string;
  user: User;

  constructor(private libraryService: LibraryService, private loginService: LoginService, private httpClient: HttpClient, private router: Router) { }

  ngOnInit() {
    this.libraryService.getOneLibrary(this.loginService.getUsername()).subscribe(libraries => {
      this.librariesList = libraries;
      
    })
}

  
boucle() {
  // for(var i = 0; i < this.librariesList.length; i ++) {
  //   this.libraryService.libraryDetail(this.librariesList[i].libraryId).subscribe(library => this.library = library);
    this.router.navigate(['/library-detail']);


    
    
  
}

}