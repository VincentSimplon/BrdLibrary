package co.vincent.brdlibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.vincent.brdlibrary.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query("SELECT m FROM Movie m WHERE m.gencode LIKE ?1")
	public Movie findByGencode(String gencode);
	
	

}