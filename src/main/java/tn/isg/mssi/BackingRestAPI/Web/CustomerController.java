package tn.isg.mssi.BackingRestAPI.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import tn.isg.mssi.BackingRestAPI.Entities.Customer;
import tn.isg.mssi.BackingRestAPI.Services.CustomerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/customers")
@CrossOrigin(origins = {"http://localhost:4200","http://localhost:3000","http://165.12.4.12:8000"})
public class CustomerController {
    @Autowired
    private CustomerService service;
 //path =http://localhost:8080/customers/
    @GetMapping("/")
    @PreAuthorize("hasRole({'ADMIN','USER'})")
    public ResponseEntity<?> allCustomers() {
        return service.getAll();
    }
    //path =http://localhost:8080/customers/5
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        return service.getCustomer(id);
    }

    @PostMapping("/")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody Customer customer) {
        return service.addCustomer(customer);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
        return service.removeCustomer(id);
    }
}
