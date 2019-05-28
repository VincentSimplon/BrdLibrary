package co.vincent.brdlibrary;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import co.vincent.brdlibrary.model.AppUser;
import co.vincent.brdlibrary.model.Role;
import co.vincent.brdlibrary.service.AppUserService;
import co.vincent.brdlibrary.service.MovieService;

@SpringBootApplication
public class BrdlibraryApplication implements CommandLineRunner {
	
	
	
	@Autowired
    AppUserService userService;

    @Autowired
    MovieService movieService;



	public static void main(String[] args) {
		SpringApplication.run(BrdlibraryApplication.class, args);
		
	}

	@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Init method that loads some data in database.
     * @param params
     * @throws Exception
     */
    @Override
    public void run(String... params) throws Exception {
//        AppUser admin = new AppUser("Vincent.Co", "simplonco", new ArrayList<>(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_CREATOR, Role.ROLE_READER)));
//        userService.addUser(admin);
}
}
