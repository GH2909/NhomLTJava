package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.UserCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.UserUpdateRequest;
import nhom_java.skincarebookingsystem.models.User;
import nhom_java.skincarebookingsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public User createUser(UserCreationRequest request){
        User user = new User();

        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setRole(request.getRole());

        return userRepository.save(user);
    }

    public User updateUser(String email, UserUpdateRequest request){
        User user = getUser(email);
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());

        return userRepository.save(user);
    }

    public void  deleteUser(String email) {
        userRepository.deleteByEmail(email);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(String email){
        return  userRepository.findByEmail(email) .orElseThrow(() -> new RuntimeException("User not found"));
    }

}
