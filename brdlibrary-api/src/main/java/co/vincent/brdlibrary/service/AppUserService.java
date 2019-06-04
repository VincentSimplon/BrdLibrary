package co.vincent.brdlibrary.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import co.vincent.brdlibrary.exception.ExistingUsernameException;
import co.vincent.brdlibrary.exception.InvalidCredentialsException;
import co.vincent.brdlibrary.model.AppUser;

@Service
public interface AppUserService {

	String login(String username, String password) throws InvalidCredentialsException;
    
    List<AppUser> findAllUsers();
    
    public String addUser(AppUser appUser) throws ExistingUsernameException;

    Optional<AppUser> findByUsername(String username);

	AppUser findByUsername1(String username);
	
	
}