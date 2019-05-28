package co.vincent.brdlibrary.service;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import co.vincent.brdlibrary.model.Movie;

@Service
public interface MovieService {
	
	List<Movie> findAllMovies();
	
	Movie addMovie(Movie newMovie);
	
	Movie addMovieByGencode(String gencode) throws IOException, ParserConfigurationException, SAXException, TransformerException;

	void deleteMovieById(long movieId);

}