package vn.fis.project.controller.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vn.fis.project.controller.api.OrderApi;
import vn.fis.project.entity.Order;

import java.util.Date;

import static vn.fis.project.controller.api.OrderApi.*;

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
        OrderApi orderApi = new OrderApi();
        String result = orderApi.insert(order);
        Assertions.assertEquals("Created!", result);
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
        OrderApi orderApi = new OrderApi();
        String result = orderApi.update(order);
        Assertions.assertEquals("Updated!", result);
    }

    @Test
    void when_delete_order_ok() {
        OrderApi orderApi = new OrderApi();
        String result = orderApi.delete(1);
        Assertions.assertEquals("Deleted!", result);
    }
}
