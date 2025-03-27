package nhom_java.skincarebookingsystem.dto.request;

public class StaffCreationRequest {
    private String email;
    private String password;
    private String role;
    private String fullName;  // Tên đầy đủ thay vì name
    private String phone;
    private String position;
    private Long workScheduleId;  // Giả sử có liên kết tới WorkSchedule

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public Long getWorkScheduleId() { return workScheduleId; }
    public void setWorkScheduleId(Long workScheduleId) { this.workScheduleId = workScheduleId; }
}
