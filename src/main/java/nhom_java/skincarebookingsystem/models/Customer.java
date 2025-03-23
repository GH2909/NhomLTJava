package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import nhom_java.skincarebookingsystem.models.User;


@Entity
@PrimaryKeyJoinColumn(name = "user_id")
public class Customer extends User {

    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String address;


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}