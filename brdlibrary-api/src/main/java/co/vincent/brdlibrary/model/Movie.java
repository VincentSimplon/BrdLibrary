package co.vincent.brdlibrary.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import lombok.Data;
//
//@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="movie")
@NamedQuery(name="Movie.findAll", query="SELECT m FROM Movie m")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="movie_id")
	private long movieId;
	private String cover;
	private String director;
	private String edition;
	private String editor;
	@Column(name="french_title")
	private String frenchTitle;
	private String media;
	@Column(name="original_title")
	private String originalTitle;
	private String year;
	private String gencode;
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="library_id")
	private Library library;
	
	public Movie(String cover, String director, String edition, String editor, String frenchTitle, String media,
			String originalTitle, String year, String gencode) {
		super();
		this.cover = cover;
		this.director = director;
		this.edition = edition;
		this.editor = editor;
		this.frenchTitle = frenchTitle;
		this.media = media;
		this.originalTitle = originalTitle;
		this.year = year;
		this.gencode = gencode;
	}
	
	
	
	public Movie(String cover, String director, String edition, String editor, String frenchTitle, String media,
			String originalTitle, String year, String gencode, Library library) {
		super();
		this.cover = cover;
		this.director = director;
		this.edition = edition;
		this.editor = editor;
		this.frenchTitle = frenchTitle;
		this.media = media;
		this.originalTitle = originalTitle;
		this.year = year;
		this.gencode = gencode;
		this.library = library;
	}



	public Movie(String cover, String director, String edition, String editor, String frenchTitle, String media,
			String originalTitle, String year) {
		super();
		this.cover = cover;
		this.director = director;
		this.edition = edition;
		this.editor = editor;
		this.frenchTitle = frenchTitle;
		this.media = media;
		this.originalTitle = originalTitle;
		this.year = year;
		
	}
	
	

	public Movie(String gencode) {
		super();
		this.gencode = gencode;
	}
	
	



	

	public Library getLibrary() {
		return library;
	}



	public void setLibrary(Library library) {
		this.library = library;
	}



	public Movie() {
		super();
	}



	public String getGencode() {
		return gencode;
	}



	public void setGencode(String gencode) {
		this.gencode = gencode;
	}



	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public String getFrenchTitle() {
		return frenchTitle;
	}

	public void setFrenchTitle(String frenchTitle) {
		this.frenchTitle = frenchTitle;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public String getOriginalTitle() {
		return originalTitle;
	}

	public void setOriginalTitle(String originalTitle) {
		this.originalTitle = originalTitle;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
		
	
}