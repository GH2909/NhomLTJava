package nhom_java.skincarebookingsystem.controllers;
import jakarta.transaction.Transactional;
import nhom_java.skincarebookingsystem.dto.request.FeedbackUpdateRequest;
import nhom_java.skincarebookingsystem.dto.request.FeedbackCreationRequest;
import nhom_java.skincarebookingsystem.models.Feedback;
import nhom_java.skincarebookingsystem.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/feed")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @PostMapping
    Feedback createFeedback(@RequestBody FeedbackCreationRequest request){
        return feedbackService.createFeedback(request);
    }

    @GetMapping
    List<Feedback> getFeedbacks() {
        return feedbackService.getFeedbacks();
    }

    @GetMapping("/{email}")
    Feedback getFeedbacks(@PathVariable String email){
        return feedbackService.getFeedback(email);
    }

    @PutMapping("/{email}")
    Feedback updateFeedback(@PathVariable String email, @RequestBody FeedbackUpdateRequest request){
        return feedbackService.updateFeedback(email, request);
    }

    @Transactional
    @DeleteMapping("/{email}")
    String deleteFeedback(@PathVariable String email){
        feedbackService.deleteFeedback(email);
        return "Feedback has been deleted";
    }
}
