package nhom_java.skincarebookingsystem.services;
import nhom_java.skincarebookingsystem.models.User;
import nhom_java.skincarebookingsystem.repositories.UserRepository;
import  org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public Optional<User> findUserByName(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAllByUser(){
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public ResponseEntity<String> deleteByUsername(String username){
        Optional<User> user =findUserByName(username);
        if (user.isPresent()){
            userRepository.delete(user.get());
            return ResponseEntity.ok("Đã được xóa");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User ko ton tai");
    }



}
