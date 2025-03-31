package nhom_java.skincarebookingsystem.models;


import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "user_id")
public class SkinTherapist extends User {
    }
