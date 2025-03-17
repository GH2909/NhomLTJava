package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nhom_java.skincarebookingsystem.models.Feedback;
import java.util.List;
@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    public List <Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    public Feedback CreateFeedback(Feedback feedback) {

        return feedbackRepository.save(feedback);
    }

    public Feedback UpdateFeedback(Feedback feedback) {

        return feedbackRepository.save(feedback);
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
