package mailapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mailapplication.model.User;
import mailapplication.service.UserService;

 

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        User existingUser = userService.findByEmail(user.getEmailAddress());       
        if (existingUser != null&& existingUser.getPassword().equals(user.getPassword())) {
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<User>>  getUsers() {
    	  List ll=userService.findAllUsers();
    	 return ResponseEntity.ok(ll);
    }
    
    @GetMapping("/allAdmin")
    public ResponseEntity<List<User>>getAllAdmin() {
    	  List ll=userService.findAllAdmin();
    	 return ResponseEntity.ok(ll);
    }
}

