package nhom_java.skincarebookingsystem.controllers;

import jakarta.transaction.Transactional;
import nhom_java.skincarebookingsystem.dto.request.FeedbackCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.FeedbackUpdateRequest;
import nhom_java.skincarebookingsystem.models.Feedback;
import nhom_java.skincarebookingsystem.models.Report;
import nhom_java.skincarebookingsystem.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/re")
public class ReportController {
    @Autowired
    private ReportService reportService;

    @PostMapping
    Report createReport(@RequestBody ReportCreationRequest request){
        return reportService.createReport(request);
    }

    @GetMapping
    List<Report> getReports() {
        return reportService.getReports();
    }

    @GetMapping("/{email}")
    Report getReports(@PathVariable String email){
        return reportService.getReport(email);
    }

    @PutMapping("/{email}")
    Report updateReport(@PathVariable String email, @RequestBody ReportUpdateRequest request){
        return reportService.updateReport(email, request);
    }

    @Transactional
    @DeleteMapping("/{email}")
    String deleteReport(@PathVariable String email){
        reportService.deleteReport(email);
        return "Report has been deleted";
    }
}
