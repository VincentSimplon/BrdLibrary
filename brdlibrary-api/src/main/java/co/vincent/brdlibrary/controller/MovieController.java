package co.vincent.brdlibrary.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import co.vincent.brdlibrary.model.Movie;
import co.vincent.brdlibrary.service.MovieService;


@RestController
@RequestMapping("/brdlibrary")
public class MovieController {
	
	private MovieService movieService;
	
	public MovieController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping("/movies")
    public List<Movie> getAllMovies() {
        return movieService.findAllMovies();
    }
	
	@PostMapping("/addMovie")
	public Movie addMovie(Movie newMovie) {
		return movieService.addMovie(newMovie);
	}
	
	@PostMapping("/addMovieByGencode")
	public Movie addMovieByGencode(@Valid String gencode) throws IOException, ParserConfigurationException, SAXException, TransformerException {
		return this.movieService.addMovieByGencode(gencode);
		
	}
	
//	@PostMapping("/addMovieByGencode")
//    public ResponseEntity<?> addMovieByGencode(@Valid String gencode)
//                                        {
//        try {
//
//            return ResponseEntity.status(HttpStatus.OK)
//                    .body(this.movieService.addMovieByGencode(gencode));
//
//        } catch (Exception e) {
//
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//        }
//
//    }
	
	@DeleteMapping("/movies/{movieId}")
	public void deleteMovieById(@PathVariable("movieId") long movieId) {
		movieService.deleteMovieById(movieId);
	}

}
