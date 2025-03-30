
package nhom_java.skincarebookingsystem.controllers;
import jakarta.transaction.Transactional;
import nhom_java.skincarebookingsystem.dto.request.ApiResponse;
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
    ApiResponse<Feedback> createFeedback(@RequestBody FeedbackCreationRequest request){
        ApiResponse<Feedback> apiResponse = new ApiResponse<>();
        apiResponse.setResult(feedbackService.createFeedback(request));
        return apiResponse;
    }

    @GetMapping
    ApiResponse<List<Feedback>> getFeedbacks() {
        ApiResponse<List<Feedback>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(feedbackService.getFeedbacks());
        return apiResponse;
    }


    @GetMapping("/{email}")
    ApiResponse<Feedback> getFeedbacks(@PathVariable String email){
        ApiResponse<Feedback> apiResponse = new ApiResponse<>();
        apiResponse.setResult(feedbackService.getFeedback(email));
        return apiResponse;
    }

    @PutMapping("/{email}")
    ApiResponse <Feedback> updateFeedback(@PathVariable String email, @RequestBody FeedbackUpdateRequest request){
        ApiResponse<Feedback> apiResponse = new ApiResponse<>();
        apiResponse.setResult(feedbackService.updateFeedback(email, request));
        return apiResponse;
    }

    @Transactional
    @DeleteMapping("/{email}")
    ApiResponse<String> deleteFeedback(@PathVariable String email) {
        ApiResponse<String> apiResponse = new ApiResponse<>();
        apiResponse.setResult("Report has been deleted");
        feedbackService.deleteFeedback(email);
        return apiResponse;
    }
}
