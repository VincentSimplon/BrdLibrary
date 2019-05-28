package co.vincent.brdlibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.vincent.brdlibrary.model.Library;

public interface LibraryRepository extends JpaRepository<Library, Long> {

}