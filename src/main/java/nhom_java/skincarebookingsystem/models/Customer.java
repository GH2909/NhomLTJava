package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;


@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends User {
}