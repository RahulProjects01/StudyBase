package mailapplication.service;

import java.util.List;

import mailapplication.model.User;

public interface UserService {
    User registerUser(User user);
    
    User findByEmail(String email);
    
    List<User> findAllUsers();
    
    List<User> findAllAdmin();
}

