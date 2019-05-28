package co.vincent.brdlibrary.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.vincent.brdlibrary.model.AppUser;
import co.vincent.brdlibrary.repository.AppUserRepository;

@Service
public class AppUserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<AppUser> appUser = appUserRepository.findByUsername(username);

        if (!appUser.isPresent()) {
            throw new UsernameNotFoundException("User '" + username + "' not found");
        }

        return User
        		
                .withUsername(username)
                .password(appUser.get().getPassword())
                .authorities(appUser.get().getRoleList())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}