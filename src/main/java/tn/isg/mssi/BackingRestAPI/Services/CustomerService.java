package tn.isg.mssi.BackingRestAPI.Services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tn.isg.mssi.BackingRestAPI.Entities.Customer;
import tn.isg.mssi.BackingRestAPI.Repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private static final Log LOG = LogFactory.getLog(CustomerService.class);
    @Autowired
    private CustomerRepository repository;

    //public List<Customer> getAll() {
     //   LOG.info("getting all customers");
     //   return repository.findAll();
    //}
    public ResponseEntity<List<Customer>> getAll()
    {
        List<Customer> lstCustomers = repository.findAll();
        if(lstCustomers.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(lstCustomers);
    }

    public ResponseEntity<?> getCustomer(Long id)
    {
        Optional<Customer> res= repository.findById(id);
        if(res.isEmpty())
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("The customer with id = " + id + " is not available.");
        return ResponseEntity.ok(res.get());
    }
    //example of Stream use :
    //return a Set containing the triple of even integer into the list 11,4,3,8,6,15
    //Stream.of(11,4,3,8,6,15)
    //.filter(x->x%2==0) //returns a stream containing 4, 8 and 6.
    //.filter(x->x<8) //returns a stream containing 4 and 6
    //.map(x->3*x) //returns a stream containing 12 and 18
    //.collect(Collectors.toSet())
    public ResponseEntity<?> addCustomer(Customer customer) {
        List<Customer> lstCustomers = repository.findAll().stream() //convert from List to Stream
                .filter(c -> c.getCin().equals(customer.getCin()))
                .collect(Collectors.toList()); //convert from Stream to List
        if(!lstCustomers.isEmpty())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A customer with same cin value already exists");

        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(customer));
    }

    public ResponseEntity<?> removeCustomer(Long id) {
        Optional<Customer> res= repository.findById(id);
        if(res.isEmpty())
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("The customer with id = " + id + " is not available.");
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("The customer with id ="+ id+" was successfully deleted");
    }
}
