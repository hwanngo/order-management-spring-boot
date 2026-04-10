package vn.fis.project.controller.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vn.fis.project.service.intf.OrderService;
import vn.fis.project.entity.Order;

import java.util.Date;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class OrderApiTest {
    @Test
    void when_create_order_ok() {
        Order order = new Order();
        order.setOrderNo("OD20200228.test-create");
        order.setUserId(1);
        order.setAmount(15);
        order.setOrderDate(new Date());
        order.setStatus(2);
        order.setCustomer("FIS");

        OrderService orderService = mock(OrderService.class);
        OrderApi orderApi = new OrderApi();
        orderApi.setOrderService(orderService);

        String result = orderApi.insert(order);

        Assertions.assertEquals("Created!", result);
        verify(orderService).create(order);
    }

    @Test
    void when_update_order_ok() {
        Order order = new Order();
        order.setId(1);
        order.setOrderNo("OD20200228.test-update");
        order.setUserId(2);
        order.setAmount(10);
        order.setOrderDate(new Date());
        order.setStatus(0);
        order.setCustomer("FIS");

        OrderService orderService = mock(OrderService.class);
        OrderApi orderApi = new OrderApi();
        orderApi.setOrderService(orderService);

        String result = orderApi.update(order);

        Assertions.assertEquals("Updated", result);
        verify(orderService).update(order);
    }

    @Test
    void when_delete_order_ok() {
        OrderService orderService = mock(OrderService.class);
        OrderApi orderApi = new OrderApi();
        orderApi.setOrderService(orderService);

        String result = orderApi.delete(1);

        Assertions.assertEquals("Deleted!", result);
        verify(orderService).deleteById(1);
    }
}
