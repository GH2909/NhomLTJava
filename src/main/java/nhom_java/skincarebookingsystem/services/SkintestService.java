package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.models.Skintest;
import nhom_java.skincarebookingsystem.repositories.SkintestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SkintestService {
    @Autowired
    private SkintestRepository skintestRepository;
    public List<Skintest> findAll() {
        return skintestRepository.findAll();
    }
    public Skintest CreateSkintest(Skintest skintest){
        return skintestRepository.save(skintest);
    }
    public Skintest updateSkintest(Skintest skintest){
        return skintestRepository.save(skintest);
    }
    public void deleteSkintest(Long id) {
        if (skintestRepository.existsById(id)) {
            skintestRepository.deleteById(id);
        } else {
            throw new RuntimeException("Skintest with ID " + id + " not found");
        }
    }
}
