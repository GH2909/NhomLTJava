package nhom_java.skincarebookingsystem.controllers;
import nhom_java.skincarebookingsystem.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import nhom_java.skincarebookingsystem.services.RatingService;
import java.util.List;
import nhom_java.skincarebookingsystem.models.Rating;


@RestController
//REST API
@RequestMapping("/rat")
public class RatingController {
    @Autowired
    private RatingService ratingService;
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
    @GetMapping("/ratings")
    public List<Rating> getAllRatings() {
        return ratingService.findAll();
    }
    @PostMapping("/rating")
    public Rating addRating(@RequestBody Rating rating) {
        return ratingService.CreateRating(rating);
    }
    @PutMapping("/rating/{id}")
    public Rating updateRating(Rating rating) {
        return ratingService.CreateRating(rating);
    }

    @DeleteMapping("/rating/{id}")
    public ResponseEntity<String> deleteRating(@PathVariable Long id) {
        ratingService.deleteRating(id);
        return ResponseEntity.ok("Deleted successfully!");
    }
}
