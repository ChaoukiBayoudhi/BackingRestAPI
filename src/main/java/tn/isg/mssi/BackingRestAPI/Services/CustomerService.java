package tn.isg.mssi.BackingRestAPI.Services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.isg.mssi.BackingRestAPI.Entities.Customer;
import tn.isg.mssi.BackingRestAPI.Repositories.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private static final Log LOG = LogFactory.getLog(CustomerService.class);
    @Autowired
    private CustomerRepository repository;

    public List<Customer> getAll() {
        LOG.info("getting all customers");
        return repository.findAll();
    }
}
