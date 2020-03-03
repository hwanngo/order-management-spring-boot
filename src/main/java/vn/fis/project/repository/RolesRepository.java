package vn.fis.project.repository;

import org.springframework.data.repository.CrudRepository;
import vn.fis.project.entity.Role;

public interface RolesRepository extends CrudRepository<Role, Integer> {
    Role findByRoleName(String roleName);
}
