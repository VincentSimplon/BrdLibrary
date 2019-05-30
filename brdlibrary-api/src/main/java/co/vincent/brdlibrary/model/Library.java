package co.vincent.brdlibrary.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="library")
@NamedQuery(name="Library.findAll", query="SELECT l FROM Library l")
public class Library implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="library_id")
	private long libraryId;

	private String name;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private AppUser appUser;

	//bi-directional many-to-many association to Movie
	@ManyToMany
	@JoinTable(
		name="library_movie"
		, joinColumns={
			@JoinColumn(name="library_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="movie_id")
			}
		)
	private List<Movie> movies;

	public Library() {
		super();
	}

	public Library(String name, AppUser appUser, List<Movie> movies) {
		super();
		this.name = name;
		this.appUser = appUser;
		this.movies = movies;
	}
	
	
	
}