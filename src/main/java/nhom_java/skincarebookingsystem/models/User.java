package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Long id;
     String email;
     String password;
     Set<String> role;

    }