package nhom_java.skincarebookingsystem.controllers;
import nhom_java.skincarebookingsystem.models.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nhom_java.skincarebookingsystem.services.FeedbackService;
import java.util.List;
import nhom_java.skincarebookingsystem.models.Feedback;


@RestController
//REST API
@RequestMapping("/feed")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
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
    @GetMapping("/feedbacks")
    public List<Feedback> getAllFeedbacks() {
        return feedbackService.findAll();
    }
    @PostMapping("/feedback")
    public Feedback addFeedback(@RequestBody Feedback feedback) {
        return feedbackService.CreateFeedback(feedback);
    }
    @PutMapping("/feedback/{id}")
    public Feedback updateFeedback(@RequestBody Feedback feedback) {
        return feedbackService.CreateFeedback(feedback);
    }

    @DeleteMapping("/feedback/{id}")
    public ResponseEntity<String> deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.ok("Deleted successfully!");
    }
}
