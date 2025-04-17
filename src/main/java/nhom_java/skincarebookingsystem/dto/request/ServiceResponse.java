package nhom_java.skincarebookingsystem.dto.request;

public class ServiceResponse {
    private Long serviceId;
    private String name;
    private String description;
    private Double price;
    private Integer duration;
    private String imageUrl; // thêm ảnh

    public ServiceResponse(Long serviceId, String name, String description, Double price, Integer duration, String imageUrl) {
        this.serviceId = serviceId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.duration = duration;
        this.imageUrl = imageUrl;
    }

    // Getters
    public Long getServiceId() { return serviceId; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public Double getPrice() { return price; }

    public Integer getDuration() { return duration; }

    public String getImageUrl() { return imageUrl; }
}
