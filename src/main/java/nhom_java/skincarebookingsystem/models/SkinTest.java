package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class SkinTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long skinTestID;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private LocalDate testDate;

    @Column(nullable = false)
    private String skinType;

    public SkinTest() {}

    public Long getSkinTestID() {
        return skinTestID;
    }

    public void setSkinTestID(Long skinTestID) {
        this.skinTestID = skinTestID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getTestDate() {
        return testDate;
    }

    public void setTestDate(LocalDate testDate) {
        this.testDate = testDate;
    }

    public String getSkinType() {
        return skinType;
    }

    public void setSkinType(String skinType) {
        this.skinType = skinType;
    }
}
