package vn.fis.project.service.intf;

import vn.fis.project.domain.ProductSummary;
import vn.fis.project.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> list();
    List<Order> listAll();
    Order create(Order order);
    Order update(Order order);
    void deleteById(Integer id);
    String total();
    List<ProductSummary> groupByProduct();
}
