package tn.isg.mssi.BackingRestAPI.Web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.isg.mssi.BackingRestAPI.Entities.Customer;
import tn.isg.mssi.BackingRestAPI.Services.CustomerService;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService service;

    @GetMapping("/")
    public List<Customer> allCustomers() {
        return service.getAll();
    }
}
