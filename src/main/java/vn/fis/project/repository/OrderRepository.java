package vn.fis.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fis.project.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>, OrderRepositoryJdbc {

}
