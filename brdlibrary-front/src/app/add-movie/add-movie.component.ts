import { Component, OnInit } from '@angular/core';
import { Movie } from '../model/movie.model';
import { User } from '../model/user.model';
import { environment } from 'src/environments/environment';
import * as jwt_decode from 'jwt-decode';
import { DataService } from '../service/data.service';
import { Library } from '../model/library.model';
import { ActivatedRoute } from '@angular/router';
import { LibraryDetailComponent } from '../library-detail/library-detail.component';
import { LibraryService } from '../service/library.service';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-add-movie',
  templateUrl: './add-movie.component.html',
  styleUrls: ['./add-movie.component.css']
})
export class AddMovieComponent implements OnInit {

  newMovie: Movie;
  username: string;
  user: User;
  gencode: string;
  library: Library = new Library;
  libraryId: number;
  newMovieByGencode: Movie;
  


  constructor(private httpClient: HttpClient ,private dataService: DataService, private route: ActivatedRoute, private libraryService: LibraryService) { }

  ngOnInit() {
    
    
    this.libraryId = this.route.snapshot.params.libraryId;
    this.libraryService.findLibrary(this.libraryId).subscribe(library => this.library = library);
    console.log("ID NGON : " + this.libraryId)

    this.newMovie = new Movie("", "", "", "", "", "", "", "", "", this.library);
    this.newMovieByGencode = new Movie("", "", "", "", "", "", "", "", this.gencode, this.library);
  }

  addMovie() {
    console.log("ID : " + this.libraryId)
    this.dataService.addMovie(this.newMovie, this.libraryId);

  }

  addMovieByGencode(gencodeTest: string) {
    this.dataService.addMovieByGencode(gencodeTest, this.libraryId)
    console.log("GENCODE : " + this.newMovieByGencode.gencode)
  }

}
