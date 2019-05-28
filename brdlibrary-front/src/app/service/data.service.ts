import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from '../model/movie.model';
import { environment } from '../../environments/environment';
import { User } from '../model/user.model';

@Injectable({
    providedIn: 'root'
})
export class DataService {

    constructor(private httpClient: HttpClient) {

    }

    getAllMovies(): Observable<Movie[]> {
        return this.httpClient.get<Movie[]>(environment.apiUrl + 'movies');
    }

   
}