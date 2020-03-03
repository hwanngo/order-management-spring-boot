package vn.fis.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fis.project.entity.Order;
import vn.fis.project.entity.OrderLine;
import vn.fis.project.repository.OrderLineRepository;
import vn.fis.project.repository.OrderRepository;
import vn.fis.project.service.intf.OrderLineService;

@Service
public class OrderLineServiceImpl implements OrderLineService {
    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderLine add(OrderLine orderLine) {
        Order order = orderRepository.getOne(orderLine.getOrderId());
        order.setAmount(order.getAmount() + orderLine.getAmount());
        orderRepository.save(order);
        return orderLineRepository.save(orderLine);
    }

    @Override
    public OrderLine update(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }

    @Override
    public void deleteById(Integer id) {
        OrderLine orderLine = orderLineRepository.getOne(id);
        Order order = orderRepository.getOne(orderLine.getOrderId());
        order.setAmount(order.getAmount() - orderLine.getAmount());
        orderRepository.save(order);
        orderLineRepository.deleteById(id);
    }

    public void delete(OrderLine orderLine) {
        Order order = orderRepository.getOne(orderLine.getOrderId());
        order.setAmount(order.getAmount() - orderLine.getAmount());
        orderRepository.save(order);
        orderLineRepository.delete(orderLine);
    }

    public OrderLineRepository getOrderLineRepository() {
        return orderLineRepository;
    }

    public void setOrderLineRepository(OrderLineRepository orderLineRepository) {
        this.orderLineRepository = orderLineRepository;
    }


}
