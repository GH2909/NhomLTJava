package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;

@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId; // Khóa chính

    @Column(nullable = false, unique = true)
    private String name; // Tên dịch vụ

    @Column(nullable = false)
    private String description; // Mô tả dịch vụ

    @Column(nullable = false)
    private Double price; // Giá dịch vụ

    @Column(nullable = false)
    private Integer duration; // Thời gian thực hiện (phút)

    public Service() {}

    // Getters and Setters
    public Long getServiceId() { return serviceId; }
    public void setServiceId(Long serviceId) { this.serviceId = serviceId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
}
