package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ManagerID", nullable = false)
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User userID;

    @ColumnDefault("b'0'")
    @Column(name = "ManageServices")
    private Boolean manageServices;

    @ColumnDefault("b'0'")
    @Column(name = "ManageWorkSchedule")
    private Boolean manageWorkSchedule;

    @ColumnDefault("b'0'")
    @Column(name = "ManageTherapists")
    private Boolean manageTherapists;

    @ColumnDefault("b'0'")
    @Column(name = "ManagePayments")
    private Boolean managePayments;

    @ColumnDefault("b'0'")
    @Column(name = "MonitorFeedback")
    private Boolean monitorFeedback;

    @ColumnDefault("b'0'")
    @Column(name = "ViewReports")
    private Boolean viewReports;

    @ColumnDefault("b'0'")
    @Column(name = "ManageCustomers")
    private Boolean manageCustomers;

}