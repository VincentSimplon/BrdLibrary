package co.vincent.brdlibrary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.vincent.brdlibrary.model.Library;

public interface LibraryRepository extends JpaRepository<Library, Long> {
	
	@Query("SELECT u FROM Library u WHERE u.appUser.username = ?1")
    List<Library> findLibraryByUsername(String username);

}