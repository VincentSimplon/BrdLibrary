package co.vincent.brdlibrary.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.vincent.brdlibrary.exception.ExistingUsernameException;
import co.vincent.brdlibrary.exception.InvalidCredentialsException;
import co.vincent.brdlibrary.model.AppUser;
import co.vincent.brdlibrary.model.Role;
import co.vincent.brdlibrary.repository.AppUserRepository;
import co.vincent.brdlibrary.security.JwtTokenProvider;


@Service
public class AppUserServiceImpl implements AppUserService {
	
    private AppUserRepository appUserRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private AuthenticationManager authenticationManager;
    
    
    
    public AppUserServiceImpl(AppUserRepository appUserRepository) {
		super();
		this.appUserRepository = appUserRepository;
	}

	@Override
    public String addUser(AppUser user) throws ExistingUsernameException {
 
    
        if (!appUserRepository.existsByUsername(user.getUsername())) {
            AppUser userToSave = new AppUser(user.getEmail(),
            					 			 passwordEncoder.encode(user.getPassword()), 
            					 			 user.getProfilePicture(),
            					 			 user.getAddressLine1(), 
            					 			 user.getAddressLine2(), 
            					 			 user.getCity(), 
            					 			 user.getCountry(),
            					 			 user.getFirstName(), 
            					 			 user.getUsername(), 
            					 			 user.getLastName(), 
            					 			 user.getZipCode(),
            					 			 new ArrayList<>(Arrays.asList(Role.ROLE_USER)),
            					 			 user.getMovies());
            					 			 
            appUserRepository.save(userToSave);
            
            return jwtTokenProvider.createToken(user.getUsername(), new ArrayList<>(Arrays.asList(Role.ROLE_USER)));
        } else {
            throw new ExistingUsernameException();
        }
    }
    
    @Override
    public String login(String username, String password) throws InvalidCredentialsException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            return jwtTokenProvider.createToken(username, appUserRepository.findByUsername(username).get().getRoleList());
        } catch (AuthenticationException e) {
            throw new InvalidCredentialsException();
        }
    }

    @Override
    public List<AppUser> findAllUsers() {
        return appUserRepository.findAll();
    }

    @Override
    public Optional<AppUser> findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

	@Override
	public AppUser findByUsername1(String username) {
		// TODO Auto-generated method stub
		return appUserRepository.findByUsername1(username);
	}
	
}