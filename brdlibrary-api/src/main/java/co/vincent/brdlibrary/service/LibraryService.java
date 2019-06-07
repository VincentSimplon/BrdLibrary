package co.vincent.brdlibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.vincent.brdlibrary.model.Library;

@Service
public interface LibraryService {
	
	List<Library> findAllLibraries();
	
	Library addLibrary(Library newLibrary, String username);
	
	void deleteLibraryById(long libraryId);
	
	List<Library> findLibraryByUsername(String username);
	
	Library findLibraryById(long libraryId);

}