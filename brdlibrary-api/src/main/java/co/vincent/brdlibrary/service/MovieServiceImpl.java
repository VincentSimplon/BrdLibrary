package co.vincent.brdlibrary.service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import co.vincent.brdlibrary.model.Library;
import co.vincent.brdlibrary.model.Movie;
import co.vincent.brdlibrary.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private LibraryService libraryService;
	
	public MovieServiceImpl(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	@Override
    public List<Movie> findAllMovies() {
        return movieRepository.findAll();
    }
	
	
	@Override
    public Movie addMovie(Movie newMovie, long libraryId) {
		
		Movie movieToSave = null;
		String cover = newMovie.getCover();
		String director = newMovie.getDirector();
		String edition = newMovie.getEdition();
		String editor = newMovie.getEditor();
		String frenchTitle = newMovie.getFrenchTitle();
		String media = newMovie.getMedia();
		String originalTitle = newMovie.getOriginalTitle();
		String year = newMovie.getYear();
		String gencode = newMovie.getGencode();
		Library library = this.libraryService.findLibraryById(libraryId);
		
		movieToSave = new Movie(cover, director, edition, editor, frenchTitle, media,
				originalTitle, year, gencode, library);
		
		
        return movieRepository.save(movieToSave);
    }
	
	@Override
	public Movie addMovieByGencode(String gencode, long libraryId) throws IOException, ParserConfigurationException, SAXException, TransformerException {
		
		
		Library library = this.libraryService.findLibraryById(libraryId);
		URL url = new URL("https://www.dvdfr.com/api/search.php?gencode=" + gencode);
		URLConnection conn = url.openConnection();

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse(conn.getInputStream());

		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer xform = transformerFactory.newTransformer();

		StreamResult res = new StreamResult(System.out);

		xform.transform(new DOMSource(doc), res);

		Element racine = doc.getDocumentElement();

		NodeList covers = racine.getElementsByTagName("cover");
		NodeList editors = racine.getElementsByTagName("editeur");
		NodeList editions = racine.getElementsByTagName("edition");
		NodeList medias = racine.getElementsByTagName("media");
		NodeList directors = racine.getElementsByTagName("star");
		NodeList titlesvf = racine.getElementsByTagName("fr");
		NodeList titlesvo = racine.getElementsByTagName("vo");
		NodeList years = racine.getElementsByTagName("annee");
		

		System.out.println("Vincent : repère");
		
		Element cover2 = (Element) covers.item(0);
		Element editor2 = (Element) editors.item(0);
		Element edition2 = (Element) editions.item(0);
		Element media2 = (Element) medias.item(0);
		Element director2 = (Element) directors.item(0);
		Element titlevf2 = (Element) titlesvf.item(0);
		Element titlevo2 = (Element) titlesvo.item(0);
		Element year2 = (Element) years.item(0);
		
		
		
		
		
		Movie newMovie = new Movie(cover2.getTextContent().toString(), 
									director2.getTextContent().toString(), 
									edition2.getTextContent().toString(),
								   editor2.getTextContent().toString(),
								   titlevf2.getTextContent().toString(),
								   media2.getTextContent().toString(),
								   titlevo2.getTextContent().toString(), 
								   year2.getTextContent().toString(),
								   gencode, library
								   
								   
								   );
		
		
		
		
		System.out.println("LE NOUVEAU FILM EST : " + newMovie.getLibrary());
									
		movieRepository.save(newMovie);
		
		return newMovie;
		
		

		
	}
	
	@Override
	public void deleteMovieById(long movieId) {
		movieRepository.deleteById(movieId);
	}
	
	}
	
