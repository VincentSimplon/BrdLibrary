import { Component, OnInit, ViewChild } from '@angular/core';
import { DataService } from '../service/data.service'
import { Movie } from '../model/movie.model';
import { BehaviorSubject } from 'rxjs';
import { User } from '../model/user.model';
import { ActivatedRoute } from '@angular/router';
import {PageEvent, MatPaginator} from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movieList: Movie[] = [];
  
  librayId: number;
  

  constructor(private dataService: DataService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.librayId = this.route.snapshot.params.libraryId;
    this.dataService.getMoviesByLibraryId(this.librayId);
    this.dataService.getAllMovies().subscribe(movies => { 
      this.movieList = movies;
      
    })
    

    
   
  }
  
  

}

