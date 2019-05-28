import { Component, OnInit } from '@angular/core';
import { DataService } from '../service/data.service'
import { Movie } from '../model/movie.model';
import { BehaviorSubject } from 'rxjs';
import { User } from '../model/user.model';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movieList: Movie[] = [];

  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.dataService.getAllMovies().subscribe(movies => this.movieList = movies);
  }

}