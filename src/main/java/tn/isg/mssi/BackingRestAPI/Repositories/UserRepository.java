package tn.isg.mssi.BackingRestAPI.Repositories;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.isg.mssi.BackingRestAPI.Entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
