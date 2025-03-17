package nhom_java.skincarebookingsystem.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import nhom_java.skincarebookingsystem.services.UserService;
import nhom_java.skincarebookingsystem.repositories.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import java.util.*;
import nhom_java.skincarebookingsystem.models.User;
import org.springframework.stereotype.Controller;
@Controller
@RestController
@RequestMapping("/u")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping ("/users")
    public List<User> findAllByUser(){
        return userService.findAllByUser();
    }
    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }
    @PutMapping("/user")
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @DeleteMapping("/user/{userName}")
    public ResponseEntity<String> deleteUser(@RequestBody String username){
        Optional<User> user =userService.findUserByName(username);
        if (user.isPresent()){
            user=Optional.empty();
            return ResponseEntity.ok("Đã được xóa");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User ko ton tai");
    }
}
