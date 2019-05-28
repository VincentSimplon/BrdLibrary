package co.vincent.brdlibrary.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.vincent.brdlibrary.dto.JsonWebToken;
import co.vincent.brdlibrary.exception.ExistingUsernameException;
import co.vincent.brdlibrary.exception.InvalidCredentialsException;
import co.vincent.brdlibrary.model.AppUser;
import co.vincent.brdlibrary.service.AppUserService;

@RestController
@RequestMapping("/brdlibrary") 
public class AppUserController {
	private AppUserService appUserService;

	public AppUserController(AppUserService appUserService) {
		this.appUserService = appUserService;
	}

	@PostMapping("/addUser")
	public ResponseEntity<JsonWebToken> addUser(@RequestBody AppUser appUser) {
		try {

			return ResponseEntity.ok(new JsonWebToken(appUserService.addUser(appUser)));

		} catch (ExistingUsernameException ex) {

			return ResponseEntity.badRequest().build();

		}
	}

	@PostMapping("/login")
	public ResponseEntity<JsonWebToken> login(@RequestBody AppUser user) {
		try {
			return ResponseEntity.ok(new JsonWebToken(appUserService.login(user.getUsername(), user.getPassword())));
		} catch (InvalidCredentialsException ex) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/users")
	public List<AppUser> getAllUsers() {
		return appUserService.findAllUsers();
	}
	
	@GetMapping("/profil/{username}")
	public Optional<AppUser> findByUsername(@PathVariable String username) {
		return appUserService.findByUsername(username);
		
	}
	

}