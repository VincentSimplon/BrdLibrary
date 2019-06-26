import { Injectable } from "@angular/core";
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Movie } from '../model/movie.model';
import { environment } from '../../environments/environment';
import { User } from '../model/user.model';
import { Library } from '../model/library.model';

@Injectable({
    providedIn: 'root'
})
export class DataService {

    moviesList: Movie[] = [];
    movie: Movie = new Movie;
    

    constructor(private httpClient: HttpClient) {

    }

    getAllMovies(): Observable<Movie[]> {
        return this.httpClient.get<Movie[]>(environment.apiUrl + 'movies');
    }

    getMoviesByLibraryId(libraryId: number): Observable<Movie[]> {
        return this.httpClient.get<Movie[]>(environment.apiUrl + 'movies/' + libraryId);
    }

    addMovie(newMovie: Movie, libraryId: number) {
        this.httpClient.post<Movie>(environment.apiUrl + 'addMovie/' + libraryId, newMovie).subscribe(newMovie => {
            this.moviesList.push(newMovie);
        }
        )
    }

    addMovieByGencode(gencode: String, libraryId: number) {
        this.httpClient.post<Movie>(environment.apiUrl + 'addmoviebygencode/' + libraryId + '/' + gencode, null).subscribe(newMovie => {
            this.moviesList.push(newMovie);
            
            
        })
    }
}
    

