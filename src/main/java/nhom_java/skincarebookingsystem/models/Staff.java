package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "staff")
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StaffID", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User userID;

    @Column(name = "NameStaff", length = 100)
    private String nameStaff;

    @Column(name = "Phone", length = 11)
    private String phone;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "Position", length = 50)
    private String position;

}