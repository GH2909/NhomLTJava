package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "skintherapist")
public class Skintherapist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TherapistID", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User userID;

    @Column(name = "TherapistName", length = 50)
    private String therapistName;

    @Column(name = "Specialization")
    private String specialization;

    @Column(name = "ExperienceYears")
    private Integer experienceYears;

    @Lob
    @Column(name = "DescriptionS")
    private String descriptionS;

    @Column(name = "Images")
    private byte[] images;

}