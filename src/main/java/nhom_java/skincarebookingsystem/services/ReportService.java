package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.repositories.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nhom_java.skincarebookingsystem.models.Report;
import java.util.List;
@Service
public class ReportService {
    @Autowired
    private ReportRepository reportRepository;
    public List <Report> findAll() {
        return reportRepository.findAll();
    }

    public Report CreateReport(Report report) {
        return reportRepository.save(report);
    }

    public Report UpdateReport(Report report) {
        return reportRepository.save(report);
    }
}



