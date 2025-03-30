package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.SkinTherapistCreationRequest;

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
    public SkinTherapist createSkinTherapist(SkinTherapistCreationRequest request) {
        SkinTherapist thera = new SkinTherapist();
        if (skinTherapistRepository.existsByEmail((request.getEmail())))
            throw new AppException(ErrorCode.USER_EXISTED);
        thera.setEmail(request.getEmail());
        thera.setPassword(request.getPassword());
        thera.setSkinTherapistName(request.getSkinTherapistName());
        thera.setDescriptionS(request.getDescriptionS());
        thera.setSpecialization(request.getSpecialization());
        thera.setExperienceYears(request.getExperienceYears());
        thera.setImages(request.getImages());

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        thera.setPassword(passwordEncoder.encode(request.getPassword()));
        return skinTherapistRepository.save(thera);
    }

    public SkinTherapist updateSkinTherapist(String email, SkinTherapistUpdateRequest request) {
        SkinTherapist thera= getSkinTherapist(email);
        thera.setPassword(request.getPassword());
        thera.setSkinTherapistName(request.getSkinTherapistName());
        thera.setDescriptionS(request.getDescriptionS());
        thera.setSpecialization(request.getSpecialization());
        thera.setExperienceYears(request.getExperienceYears());
        thera.setImages(request.getImages());
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
