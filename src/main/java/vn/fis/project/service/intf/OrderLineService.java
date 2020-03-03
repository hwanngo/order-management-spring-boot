package vn.fis.project.service.intf;

import vn.fis.project.entity.OrderLine;

public interface OrderLineService {
    OrderLine add(OrderLine orderLine);
    OrderLine update(OrderLine orderLine);
    void deleteById(Integer id);
}
