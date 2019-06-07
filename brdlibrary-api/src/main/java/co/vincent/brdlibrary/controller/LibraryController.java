package co.vincent.brdlibrary.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.vincent.brdlibrary.model.Library;
import co.vincent.brdlibrary.service.LibraryService;

@RestController
@RequestMapping("/brdlibrary")
public class LibraryController {
	
	private LibraryService libraryService;
	
	public LibraryController(LibraryService libraryService) {
		this.libraryService = libraryService;
	}
	
	@GetMapping("/libraries")
	public List<Library> getAllLibraries() {
		return libraryService.findAllLibraries();
	}
	
	@GetMapping("/libraries/user/{username}")
	public List<Library> findLibraryByUsername(@PathVariable("username") String username) {
		return libraryService.findLibraryByUsername(username);
	}
	
	@GetMapping("/libraries/{libraryId}")
	public Library findLibraryById(@PathVariable("libraryId") long libraryId) {
		return libraryService.findLibraryById(libraryId);
	}
	
	@PostMapping("/addLibrary/{username}")
	public Library addLibrary(@RequestBody Library newLibrary, @PathVariable String username) {
		return libraryService.addLibrary(newLibrary, username);
	}
	
	@DeleteMapping("/libraries/{libraryId}")
	public void deleteLibraryById(@PathVariable("libraryId") long libraryId) {
		libraryService.deleteLibraryById(libraryId);
	}

}
