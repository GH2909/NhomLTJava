package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.dto.request.CustomerprofileCreationRequest;
import nhom_java.skincarebookingsystem.dto.request.CustomerprofileUpdateRequest;
import nhom_java.skincarebookingsystem.models.Customerprofile;
import nhom_java.skincarebookingsystem.repositories.CustomerprofileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CustomerprofileService {
    @Autowired
    private CustomerprofileRepository customerprofileRepository;

//    @Autowired
//    private CustomerService customerService;
    public Customerprofile createCustomerprofile(CustomerprofileCreationRequest request) {
        Customerprofile cusCuspro = new Customerprofile();
        cusCuspro.setEmail(cusCuspro.getEmail());
        cusCuspro.setBookingHistory(request.getBookingHistory());
        cusCuspro.setNotes(request.getNotes());
        cusCuspro.setLastVisit(request.getLastVisit());
        cusCuspro.setSkinIssues(request.getSkinIssues());
        cusCuspro.setSkinType(request.getSkinType());
        return customerprofileRepository.save(cusCuspro);
    }

    public Customerprofile updateCustomerprofile(String email, CustomerprofileUpdateRequest request){
        Customerprofile cusCuspro = getCustomerprofile(email);
        cusCuspro.setBookingHistory(request.getBookingHistory());
        cusCuspro.setNotes(request.getNotes());
        cusCuspro.setLastVisit(request.getLastVisit());
        cusCuspro.setSkinIssues(request.getSkinIssues());
        cusCuspro.setSkinType(request.getSkinType());
        return customerprofileRepository.save(cusCuspro);
    }

    public List<Customerprofile>getCustomerprofiles() {
        return customerprofileRepository.findAll();
    }
    public Customerprofile getCustomerprofile(String email) {
        return customerprofileRepository.findByEmail(email) .orElseThrow(() -> new RuntimeException("Customerprofile not found"));
    }
    public void deleteCustomerprofile(String email) {
        customerprofileRepository.deleteByEmail(email);
    }

}
