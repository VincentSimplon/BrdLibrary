package co.vincent.brdlibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.vincent.brdlibrary.model.Library;
import co.vincent.brdlibrary.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query(value = "SELECT * FROM movie WHERE gencode Like ?1", nativeQuery = true)
	public Movie findByGencode(String gencode);
	
	@Query(value = "SELECT * FROM movie WHERE library_id Like ?1", nativeQuery = true)
    public List<Movie> findMoviesByLibraryId(long libraryId);
	
	

}