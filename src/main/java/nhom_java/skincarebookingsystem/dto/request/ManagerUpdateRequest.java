package nhom_java.skincarebookingsystem.dto.request;

public class ManagerUpdateRequest {
    private String password;
    private boolean manageServices;
    private boolean manageWorkSchedule;
    private boolean manageTherapists;
    private boolean managePayments;
    private boolean monitorFeedback;
    private boolean viewReports;
    private boolean manageCustomers;

    // Getters and Setters
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

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
