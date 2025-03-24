package nhom_java.skincarebookingsystem.services;
import nhom_java.skincarebookingsystem.dto.request.FeedbackCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.FeedbackUpdateRequest;
import nhom_java.skincarebookingsystem.models.Feedback;
import nhom_java.skincarebookingsystem.models.Customer;
import nhom_java.skincarebookingsystem.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository ;

    @Autowired
    private CustomerService customerService;
    public Feedback createFeedback(FeedbackCreationRequest request) {
        Customer cusFeed = customerService.getCustomer(request.getEmail());
        Feedback feedback = new Feedback();
        feedback.setEmail(cusFeed.getEmail());
        feedback.setContent(request.getContent());
        feedback.setRating(request.getRating());
        feedback.setFeedbackDate(request.getFeedbackDate());
        return feedbackRepository.save(feedback);
    }

    public Feedback updateFeedback(String email, FeedbackUpdateRequest request) {
        Feedback feedback = getFeedback(email);
        feedback.setContent(request.getContent());
        feedback.setRating(request.getRating());
        feedback.setFeedbackDate(request.getFeedbackDate());
        return feedbackRepository.save(feedback);
    }

    public List<Feedback> getFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Feedback getFeedback(String email) {
        return feedbackRepository.findByEmail(email) .orElseThrow(() -> new RuntimeException("Feedback not found"));
    }

    public void deleteFeedback(String email) {
        feedbackRepository.deleteByEmail(email);
    }
}

