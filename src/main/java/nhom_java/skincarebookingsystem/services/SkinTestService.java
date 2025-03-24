package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.SkinTestCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.SkinTestUpdateRequest;
import nhom_java.skincarebookingsystem.models.Customer;
import nhom_java.skincarebookingsystem.models.SkinTest;
import nhom_java.skincarebookingsystem.repositories.CustomerRepository;
import nhom_java.skincarebookingsystem.repositories.SkinTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkinTestService {
    @Autowired
    private SkinTestRepository skinTestRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public SkinTest createSkinTest(SkinTestCreationRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerID())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        SkinTest skinTest = new SkinTest();
        skinTest.setCustomer(customer);
        skinTest.setTestDate(request.getTestDate());
        skinTest.setSkinType(request.getSkinType());

        return skinTestRepository.save(skinTest);
    }

    public SkinTest updateSkinTest(Long skinTestID, SkinTestUpdateRequest request) {
        SkinTest skinTest = getSkinTest(skinTestID);
        skinTest.setTestDate(request.getTestDate());
        skinTest.setSkinType(request.getSkinType());

        return skinTestRepository.save(skinTest);
    }

    public List<SkinTest> getSkinTests() {
        return skinTestRepository.findAll();
    }

    public SkinTest getSkinTest(Long skinTestID) {
        return skinTestRepository.findBySkinTestID(skinTestID)
                .orElseThrow(() -> new RuntimeException("Skin Test not found"));
    }

    public void deleteSkinTest(Long skinTestID) {
        skinTestRepository.deleteBySkinTestID(skinTestID);
    }
}
