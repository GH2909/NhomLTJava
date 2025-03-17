package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Skintestresult;
import nhom_java.skincarebookingsystem.repositories.SkintestresultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SkintestresultService {
    @Autowired
    private SkintestresultRepository skintestresultRepository;
    public List<Skintestresult> findAll() {
        return skintestresultRepository.findAll();
    }
    public Skintestresult CreateSkintestresult(Skintestresult skintestresult){
        return skintestresultRepository.save(skintestresult);
    }
    public Skintestresult updateSkintestresult(Skintestresult skintestresult){
        return skintestresultRepository.save(skintestresult);
    }
    public void deleteSkintestresult(Long id) {
        if (skintestresultRepository.existsById(id)) {
            skintestresultRepository.deleteById(id);
        } else {
            throw new RuntimeException("Skintestresult with ID " + id + " not found");
        }
    }
}
