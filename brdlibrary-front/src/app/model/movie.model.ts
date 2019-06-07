import { Library } from './library.model';

export class Movie {

    constructor(
                public cover?: string,
                public director?: string,
                public edition?: string,
                public editor?: string,
                public frenchTitle?: string,
                public media?: string,
                public originalTitle?: string,
                public year?: string,
                public gencode?: string,
                public library?: Library) {

                }
}