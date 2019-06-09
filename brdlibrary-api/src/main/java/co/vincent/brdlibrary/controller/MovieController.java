package co.vincent.brdlibrary.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/addMovie/{libraryId}")
	public Movie addMovie(@RequestBody Movie newMovie, @PathVariable long libraryId) {
		return movieService.addMovie(newMovie, libraryId);
	}
	
//	@PostMapping("/addMovieByGencode/{libraryId}")
//	public Movie addMovieByGencode(@Valid String gencode, @PathVariable("libraryId") long libraryId) throws IOException, ParserConfigurationException, SAXException, TransformerException {
//		return this.movieService.addMovieByGencode(gencode, libraryId);
//		
//	}
	
	@PostMapping("/addMovieByGencode/{libraryId}")
	public Movie addMovieByGencode(String gencode, @PathVariable long libraryId) throws IOException, ParserConfigurationException, SAXException, TransformerException {
		return movieService.addMovieByGencode(gencode, libraryId);
	}
	
	@DeleteMapping("/movies/{movieId}")
	public void deleteMovieById(@PathVariable("movieId") long movieId) {
		movieService.deleteMovieById(movieId);
	}

}
