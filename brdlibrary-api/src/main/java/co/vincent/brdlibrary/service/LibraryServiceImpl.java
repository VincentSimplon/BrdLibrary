package co.vincent.brdlibrary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.vincent.brdlibrary.model.Library;
import co.vincent.brdlibrary.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	private LibraryRepository libraryRepository;
	
	public LibraryServiceImpl(LibraryRepository libraryRepository) {
		this.libraryRepository = libraryRepository;
	}

	@Override
	public List<Library> findAllLibraries() {
		return libraryRepository.findAll();
	}
	
	@Override
	public Library addLibrary(Library newLibrary) {
		return libraryRepository.save(newLibrary);
	}
	
	@Override
	public void deleteLibraryById(long libraryId) {
		libraryRepository.deleteById(libraryId);
	}
	
}