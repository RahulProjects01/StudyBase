package mailapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Service;

import mailapplication.model.User;
import mailapplication.repository.UserRepository;
 

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository userRepository;


    @Override
    public User registerUser(User user) {
 
        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmailAddress(email).orElse(null);
    }
    
    
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    
    @Override
    public List<User> findAllAdmin() {
        return userRepository.findByUserType(1);
    }
}

