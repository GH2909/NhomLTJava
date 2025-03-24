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
    @GetMapping("/{email}")
    User getUser(@PathVariable String email){
        return userService.getUser(email);
    }

    @PutMapping("/{email}")
    User updateUser(@PathVariable String email, @RequestBody UserUpdateRequest request){
        return userService.updateUser(email, request);

    }

    @Transactional
    @DeleteMapping("/{email}")
    String deleteUser(@PathVariable String email){
        userService.deleteUser(email);
        return "User has been deleted";
    }
}
