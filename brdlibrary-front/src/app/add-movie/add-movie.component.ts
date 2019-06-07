import { Component, OnInit } from '@angular/core';
import { Movie } from '../model/movie.model';
import { User } from '../model/user.model';
import { environment } from 'src/environments/environment';
import * as jwt_decode from 'jwt-decode';
import { DataService } from '../service/data.service';
import { Library } from '../model/library.model';

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
  library: Library;


  constructor(private dataService: DataService) { }

  ngOnInit() {

  }}
