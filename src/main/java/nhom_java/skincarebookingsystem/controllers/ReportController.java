package nhom_java.skincarebookingsystem.controllers;

import jakarta.transaction.Transactional;
import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
import nhom_java.skincarebookingsystem.dto.request.ReportCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.ReportUpdateRequest;
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
    ApiResponse<Report> createReport(@RequestBody ReportCreationRequest request){
        ApiResponse<Report> apiResponse = new ApiResponse<>();
        apiResponse.setResult(reportService.createReport(request));
        return apiResponse;
    }

    @GetMapping
    ApiResponse<List<Report>> getReports() {
        ApiResponse<List<Report>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(reportService.getReports());
        return apiResponse;
    }

    @GetMapping("/{email}")
    ApiResponse<Report> getReports(@PathVariable String email){
        ApiResponse<Report> apiResponse = new ApiResponse<>();
        apiResponse.setResult(reportService.getReport(email));
        return apiResponse;
    }

    @PutMapping("/{email}")
    ApiResponse<Report> updateReport(@PathVariable String email, @RequestBody ReportUpdateRequest request){
        ApiResponse<Report> apiResponse = new ApiResponse<>();
        apiResponse.setResult(reportService.updateReport(email, request));
        return apiResponse;
    }

    @Transactional
    @DeleteMapping("/{email}")
    ApiResponse<String> deleteReport(@PathVariable String email){
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("Report has been deleted");
        reportService.deleteReport(email);
        return apiResponse;
    }
}
