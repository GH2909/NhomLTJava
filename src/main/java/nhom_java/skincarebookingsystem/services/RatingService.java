package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nhom_java.skincarebookingsystem.models.Rating;
import java.util.List;
@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    public List <Rating> findAll() {
        return ratingRepository.findAll();
    }

    public Rating CreateRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    public Rating UpdateRating(Rating rating) {
        return ratingRepository.save(rating);
    }
}

