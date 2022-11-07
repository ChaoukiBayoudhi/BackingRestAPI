package tn.isg.mssi.BackingRestAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.isg.mssi.BackingRestAPI.Entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //CustomerRepository repository;
    // repository.findAll() <=> executes select * from customer;
    //repository.findById(5) <=> executes select * from customer where id = 5;
    //Customer c1=new Customer();
    //c1.setName("Ahmed");
    //...
    //repository.save(c1); <=> executes insert into customer(name, ...) values("Ahmed",..)
    //repository.deleteById(5); <=> executes delete from customer where id = 5;
    //Optional<Customer> res =repository.findById(1);
    //if(res.isPresent()) <=> this customer with id = 1 is on the database
    //if(res.isEmpty()) <=> this customer with id =1 is not on the database
    //if(res.isPresent())
         //customer=res.get();
    //update the customer's information
    //customer.setName("Ahmed Amine");
    //....
    //repository.save(customer); <=> executes update Customer set name="Ahmed Amine" ... where id=1;
}
