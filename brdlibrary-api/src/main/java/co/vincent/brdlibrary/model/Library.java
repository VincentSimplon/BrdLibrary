package co.vincent.brdlibrary.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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

	@OneToMany(mappedBy = "library")
	private List<Movie> movies;

	public Library() {
		super();
	}
	
	public Library(String name) {
		this.name = name;
	}

	public Library(String name, AppUser appUser, List<Movie> movies) {
		super();
		this.name = name;
		this.appUser = appUser;
		this.movies = movies;
	}
	
	
	
}