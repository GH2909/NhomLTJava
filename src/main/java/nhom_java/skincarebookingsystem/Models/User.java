package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID", nullable = false)
    private Integer id;

    @Column(name = "Username", nullable = false, length = 50)
    private String username;

    @Column(name = "UserPassword", nullable = false)
    private String userPassword;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "PhoneNumber", length = 50)
    private String phoneNumber;

    @Column(name = "UserRole", nullable = false, length = 20)
    private String userRole;

}