package tn.isg.mssi.BackingRestAPI.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.isg.mssi.BackingRestAPI.Entities.Customer;
import tn.isg.mssi.BackingRestAPI.Repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;




    //private static final Log LOG = LogFactory.getLog(CustomerService.class)

    public List<Customer> getAll() {
        return repository.findAll();
    }
}
