package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.FeedbackCreationRequest;
import nhom_java.skincarebookingsystem.models.Customer;
import nhom_java.skincarebookingsystem.models.Feedback;
import nhom_java.skincarebookingsystem.models.Manager;
import nhom_java.skincarebookingsystem.models.Report;
import nhom_java.skincarebookingsystem.repositories.FeedbackRepository;
import nhom_java.skincarebookingsystem.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository ;

    @Autowired
    private ManagerService managerService;
    public Report createReport(ReportCreationRequest request) {
        Manager manRe = managerService.getManager(request.getEmail());
        Report report = new Report();
        report.setEmail(manRe.getEmail());
        report.setContent2(request.getContent2());
        report.setReportType(request.getReportType);
        report.setCreationDate(request.getCreationDate);
        return reportRepository.save(report);
    }
}
