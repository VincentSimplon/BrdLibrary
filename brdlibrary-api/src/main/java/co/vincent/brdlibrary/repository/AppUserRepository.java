package co.vincent.brdlibrary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.vincent.brdlibrary.model.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	

    boolean existsByUsername(String username);

    void deleteByUsername(String username);
    
    Optional<AppUser> findByUsername(String username);
    
    @Query("SELECT u FROM AppUser u WHERE u.username LIKE ?1")
    AppUser findByUsername1(String username);
    
   
    
    
}