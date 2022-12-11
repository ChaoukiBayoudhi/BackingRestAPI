package tn.isg.mssi.BackingRestAPI.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.isg.mssi.BackingRestAPI.Entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}
