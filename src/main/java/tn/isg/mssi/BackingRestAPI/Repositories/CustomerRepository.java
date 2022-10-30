package tn.isg.mssi.BackingRestAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.isg.mssi.BackingRestAPI.Entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
