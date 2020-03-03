package vn.fis.project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import vn.fis.project.domain.ProductSummary;
import vn.fis.project.jwt.CustomUserDetails;
import vn.fis.project.repository.OrderRepository;
import vn.fis.project.entity.Order;
import vn.fis.project.service.intf.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> list() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> listAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order create(Order order) {
        order.setUserId(currentUserId());
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        if (order.getUserId() == currentUserId())
            return orderRepository.save(order);
        else return null;
    }

    @Override
    public void deleteById(Integer id) {
        if (orderRepository.getOne(id).getUserId() == currentUserId() && orderRepository.getOne(id).getStatus() == 0)
            orderRepository.deleteById(id);
    }

    @Override
    public String total() {
        long count = orderRepository.count();
        double summary = 0;
        for (int i = 1; i < orderRepository.findAll().size(); i++)
            summary += orderRepository.getOne(i).getAmount();
        return "Total order = " + count + " | Total amount = " + summary;
    }

    @Override
    public List<ProductSummary> groupByProduct() {
        return orderRepository.groupByProduct();
    }

    public void delete(Order order) {
        if (order.getUserId() == currentUserId() && order.getStatus() == 0)
            orderRepository.delete(order);
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }

    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public int currentUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
        return customUserDetails.getUserId();
    }
}
