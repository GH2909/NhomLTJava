package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "user_id") // Kế thừa từ User
public class Staff extends User {

<<<<<<< HEAD

    @OneToOne
    @JoinColumn(name = "work_schedule_id")
    private WorkSchedule workSchedule; // Liên kết với WorkSchedule

=======
>>>>>>> 3de8fc829106fec34324e59ae94d102579f669e4
    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String position;

    public Staff() {}

<<<<<<< HEAD

    public WorkSchedule getWorkSchedule() { return workSchedule; }
    public void setWorkSchedule(WorkSchedule workSchedule) { this.workSchedule = workSchedule; }
=======
    // Getters and Setter
>>>>>>> 3de8fc829106fec34324e59ae94d102579f669e4

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }
}
