package co.vincent.brdlibrary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.vincent.brdlibrary.model.AppUser;
import co.vincent.brdlibrary.model.Library;
import co.vincent.brdlibrary.model.Movie;
import co.vincent.brdlibrary.repository.AppUserRepository;
import co.vincent.brdlibrary.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private AppUserRepository appUserRepository;
	
	public LibraryServiceImpl(LibraryRepository libraryRepository, AppUserRepository appUserRepository) {
		this.libraryRepository = libraryRepository;
		this.appUserRepository = appUserRepository;
		
	
	}

	@Override
	public List<Library> findAllLibraries() {
		return libraryRepository.findAll();
	}
	
	@Override
	public Library addLibrary(Library newLibrary, String username) {
		
		Library libraryToSave = null;
		String name = newLibrary.getName();
		AppUser user = this.appUserRepository.findByUsername1(username);
		List<Movie> movie = newLibrary.getMovies();
		libraryToSave = new Library(name, user, movie);
		
		
		
		return libraryRepository.save(libraryToSave);
	}
	
	@Override
	public void deleteLibraryById(long libraryId) {
		libraryRepository.deleteById(libraryId);
	}
	
}