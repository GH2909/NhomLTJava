package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.FeedbackCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.FeedbackUpdateRequest;
import nhom_java.skincarebookingsystem.models.Feedback;
import nhom_java.skincarebookingsystem.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback createFeedback(FeedbackCreationRequest request) {
        Feedback feedback = new Feedback();


        feedback.setEmail(request.getEmail());
        feedback.setContent(request.getContent());
        feedback.setFeedbackDate(request.getFeedbackDate());

        return feedbackRepository.save(feedback);
    }

    public Feedback updateFeedback(String email, FeedbackUpdateRequest request) {
        Feedback feedback= getFeedback(email);
        feedback.setContent(request.getContent());
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
