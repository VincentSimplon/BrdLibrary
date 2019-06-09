import { User } from './user.model';
import { Movie } from './movie.model';

export class Library {
    

    constructor(public libraryId?: number,
                public name?: string,
                public user?: User,
                public movies?: Movie[]
                ) {

                }

}