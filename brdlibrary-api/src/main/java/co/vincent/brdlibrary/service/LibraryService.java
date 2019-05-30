package co.vincent.brdlibrary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.vincent.brdlibrary.model.Library;

@Service
public interface LibraryService {
	
	List<Library> findAllLibraries();
	
	Library addLibrary(Library newLibrary, String username);
	
	void deleteLibraryById(long libraryId);

}