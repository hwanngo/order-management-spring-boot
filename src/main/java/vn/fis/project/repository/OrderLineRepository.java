package vn.fis.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.fis.project.entity.OrderLine;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

}
