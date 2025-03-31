package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.SkinTherapistUpdateRequest;
import nhom_java.skincarebookingsystem.exception.AppException;
import nhom_java.skincarebookingsystem.exception.ErrorCode;
import nhom_java.skincarebookingsystem.models.SkinTherapist;
import nhom_java.skincarebookingsystem.repositories.SkinTherapistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SkinTherapistService {

    @Autowired
    SkinTherapistRepository skinTherapistRepository;


    public SkinTherapist updateSkinTherapist(String email, SkinTherapistUpdateRequest request) {
        SkinTherapist thera = getSkinTherapist(email);
        thera.setPassword(request.getPassword());
        thera.setFullName(request.getFullName());
        thera.setPhoneNumber(request.getPhoneNumber());
        thera.setAddress(request.getAddress());
        return skinTherapistRepository.save(thera);
    }

    public SkinTherapist getSkinTherapist(String email) {
        return skinTherapistRepository.findByEmail(email) .orElseThrow(() -> new RuntimeException("Therapist not found"));
    }

    public List<SkinTherapist> getAllSkinTherapist() {
        return skinTherapistRepository.findAll();
    }

    public void deleteSkinTherapist(String email) {
        skinTherapistRepository.deleteByEmail(email);
    }

}
