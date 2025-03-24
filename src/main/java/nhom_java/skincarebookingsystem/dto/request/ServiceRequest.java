package nhom_java.skincarebookingsystem.dto.request;

public class ServiceRequest {
    private String name;
    private String description;
    private Double price;
    private Integer duration; // Thời gian thực hiện (phút)

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
}
