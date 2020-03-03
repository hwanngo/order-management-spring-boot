package vn.fis.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.fis.project.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
