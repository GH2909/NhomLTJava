package nhom_java.skincarebookingsystem.models;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "user_id") // Kế thừa từ User
public class Manager extends User {

    @Column(nullable = false)
    private boolean manageServices;

    @Column(nullable = false)
    private boolean manageWorkSchedule;

    @Column(nullable = false)
    private boolean manageTherapists;

    @Column(nullable = false)
    private boolean managePayments;

    @Column(nullable = false)
    private boolean monitorFeedback;

    @Column(nullable = false)
    private boolean viewReports;

    @Column(nullable = false)
    private boolean manageCustomers;

    public Manager() {}

    // Getters and Setters

    public boolean isManageServices() { return manageServices; }
    public void setManageServices(boolean manageServices) { this.manageServices = manageServices; }

    public boolean isManageWorkSchedule() { return manageWorkSchedule; }
    public void setManageWorkSchedule(boolean manageWorkSchedule) { this.manageWorkSchedule = manageWorkSchedule; }

    public boolean isManageTherapists() { return manageTherapists; }
    public void setManageTherapists(boolean manageTherapists) { this.manageTherapists = manageTherapists; }

    public boolean isManagePayments() { return managePayments; }
    public void setManagePayments(boolean managePayments) { this.managePayments = managePayments; }

    public boolean isMonitorFeedback() { return monitorFeedback; }
    public void setMonitorFeedback(boolean monitorFeedback) { this.monitorFeedback = monitorFeedback; }

    public boolean isViewReports() { return viewReports; }
    public void setViewReports(boolean viewReports) { this.viewReports = viewReports; }

    public boolean isManageCustomers() { return manageCustomers; }
    public void setManageCustomers(boolean manageCustomers) { this.manageCustomers = manageCustomers; }
}

