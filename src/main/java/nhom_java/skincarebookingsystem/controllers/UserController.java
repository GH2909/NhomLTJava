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



    @GetMapping
    List<User> getUsers(){
        return userService.getUsers();
    }
    @GetMapping("/{email}")
    User getUser(@PathVariable String email){
        return userService.getUser(email);
    }

}
