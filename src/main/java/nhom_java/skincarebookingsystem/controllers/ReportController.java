package nhom_java.skincarebookingsystem.controllers;
import nhom_java.skincarebookingsystem.models.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import nhom_java.skincarebookingsystem.services.ReportService;
import java.util.List;
import nhom_java.skincarebookingsystem.models.Report;

@RestController
//REST API
@RequestMapping("/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    //method REST
    /*
    GET: --> Lấy dữ liệu
    Get {id} url/permission?id=
    --> SQL Injection
    vì vậy url/permission/{id}
    Get url/permissions (trả về 1 list hoặc toàn bộ bảng ghi)
    POST:--> Thêm mới (create)
    PUT: --> Update toàn bộ ({/id})
    PATH: --> Update 1 phần của object ({/id})
    DELETE: --> Delete ({/id})
    Khi khai báo Controller không sử dụng động từ url
    Method sẽ quyết định hành vi của nó
     */
    @GetMapping("/reports")
    public List<Report> getAllReports() {
        return reportService.findAll();
    }
    @PostMapping("/report")
    public Report addReport(@RequestBody Report report) {
        return reportService.CreateReport(report);
    }
    @PutMapping("/report/{id}")
    public Report updateReport(@RequestBody Report report) {
        return reportService.CreateReport(report);
    }
}

