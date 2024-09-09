package mailapplication.repository;

 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mailapplication.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
	Optional<User> findByEmailAddress(String email);
	
	 @Query("select u from User u where u.userType=:type")
	List<User> findByUserType(@Param("type")int type);
    
}

