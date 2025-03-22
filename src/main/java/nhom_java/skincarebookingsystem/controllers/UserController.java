package nhom_java.skincarebookingsystem.controllers;

import jakarta.transaction.Transactional;
import nhom_java.skincarebookingsystem.dto.request.UserCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.UserUpdateRequest;
import nhom_java.skincarebookingsystem.models.User;
import nhom_java.skincarebookingsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping
    User createUser(@RequestBody UserCreationRequest request){
        return userService.createUser(request);
    }
    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/{username}")
    User getUser(@PathVariable String username){
        return userService.getUser(username);
    }

    @PutMapping("/{username}")
    User updateUser(@PathVariable String username, @RequestBody UserUpdateRequest request){
        return userService.updateUser(username, request);

    }

    @Transactional
    @DeleteMapping("/{username}")
    String deleteUser(@PathVariable String username){
        userService.deleteUser(username);
        return "User has been deleted";
    }
}
