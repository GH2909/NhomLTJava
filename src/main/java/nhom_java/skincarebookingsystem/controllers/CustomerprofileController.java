package nhom_java.skincarebookingsystem.controllers;
import nhom_java.skincarebookingsystem.models.Customerprofile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import nhom_java.skincarebookingsystem.services.CustomerprofileService;
import java.util.List;
import nhom_java.skincarebookingsystem.models.Customerprofile;

@RestController
//REST API
@RequestMapping("/cuspro")
public class CustomerprofileController {
    @Autowired
    private CustomerprofileService customerprofileService;
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
    @GetMapping("/cuspros")
    public List<Customerprofile> getAllCustomerprofiles() {
        return customerprofileService.findAll();
    }
    @PostMapping("/cuspro")
    public Customerprofile addCustomerprofile(@RequestBody Customerprofile customerprofile) {
        return customerprofileService.CreateCustomerprofile(customerprofile);
    }
    @PutMapping("/cuspro/{id}")
    public Customerprofile updateCustomerprofile(@RequestBody Customerprofile customerprofile) {
        return customerprofileService.CreateCustomerprofile(customerprofile);
    }
}

