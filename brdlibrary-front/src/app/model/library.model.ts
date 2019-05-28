import { User } from './user.model';
import { Movie } from './movie.model';

export class Library {

    constructor(private libraryId: number,
                private name: string,
                private user: User,
                private movies: Movie
                ) {

                }

}