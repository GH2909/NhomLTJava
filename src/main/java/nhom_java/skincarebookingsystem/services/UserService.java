package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.UserCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.UserUpdateRequest;
import nhom_java.skincarebookingsystem.models.User;
import nhom_java.skincarebookingsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User createUser(UserCreationRequest request){
        User user = new User();

        user.setUsername(request.getUsername());
        user.setUserPassword(request.getUserPassword());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setUserRole(request.getUserRole());

        return userRepository.save(user);
    }

    public User updateUser(String name, UserUpdateRequest request){
        User user = getUser(name);
        user.setUserPassword(request.getUserPassword());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setUserRole(request.getUserRole());

        return userRepository.save(user);
    }

    public void  deleteUser(String username) {
        userRepository.deleteByUsername(username);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String username){
        return  userRepository.findByUsername(username) .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
