package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.ReportCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.ReportUpdateRequest;
import nhom_java.skincarebookingsystem.models.Manager;
import nhom_java.skincarebookingsystem.models.Report;
import nhom_java.skincarebookingsystem.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        report.setContent(request.getContent());
        report.setReportType(request.getReportType());
        report.setCreationDate(request.getCreationDate());
        return reportRepository.save(report);
    }

    public Report updateReport(String email, ReportUpdateRequest request) {
        Report report = getReport(email);
        report.setContent(request.getContent());
        report.setReportType(request.getReportType());
        report.setCreationDate(request.getCreationDate());
        return reportRepository.save(report);
    }

    public List<Report> getReports() {
        return reportRepository.findAll();
    }

    public Report getReport(String email) {
        return reportRepository.findByEmail(email) .orElseThrow(() -> new RuntimeException("Report not found"));
    }

    public void deleteReport(String email) {

        reportRepository.deleteByEmail(email);
    }
}
