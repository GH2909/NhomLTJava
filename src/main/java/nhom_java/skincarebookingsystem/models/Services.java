package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "service")
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ServiceID", nullable = false)
    private Long id;

    @Column(name = "ServiceName", nullable = false)
    private String serviceName;

    @Column(name = "Descriptions")
    private String descriptions;

    @Column(name = "Price", nullable = false, precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "Duration", nullable = false)
    private Integer duration;

}