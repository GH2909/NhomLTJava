package nhom_java.skincarebookingsystem.services;

import nhom_java.skincarebookingsystem.repositories.CustomerprofileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nhom_java.skincarebookingsystem.models.Customerprofile;
import java.util.List;
@Service
public class CustomerprofileService {
    @Autowired
    private CustomerprofileRepository customerprofileRepository;
    public List <Customerprofile> findAll() {
        return customerprofileRepository.findAll();
    }

    public Customerprofile CreateCustomerprofile(Customerprofile customerprofile) {
        return customerprofileRepository.save(customerprofile);
    }

    public Customerprofile UpdateCustomerprofile(Customerprofile customerprofile) {
        return customerprofileRepository.save(customerprofile);
    }
}
