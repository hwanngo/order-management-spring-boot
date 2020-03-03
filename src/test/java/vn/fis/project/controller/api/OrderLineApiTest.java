package vn.fis.project.controller.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vn.fis.project.controller.api.OrderLineApi;
import vn.fis.project.entity.OrderLine;

public class OrderLineApiTest {
    @Test
    void when_add_order_line_ok() {
        OrderLine orderLine = new OrderLine();
        orderLine.setProduct("Nokia 1100i");
        orderLine.setAmount(12_000_000);
        orderLine.setQuantity(20);
        orderLine.setOrderId(1);
        OrderLineApi orderLineApi = new OrderLineApi();
        String result = orderLineApi.add(orderLine);
        Assertions.assertEquals("Added!", result);
    }

    @Test
    void when_update_order_line_ok() {
        OrderLine orderLine = new OrderLine();
        orderLine.setId(1);
        orderLine.setProduct("Nokia 1280");
        orderLine.setAmount(18_000_000);
        orderLine.setQuantity(30);
        orderLine.setOrderId(1);
        OrderLineApi orderLineApi = new OrderLineApi();
        String result = orderLineApi.update(orderLine);
        Assertions.assertEquals("Updated!", result);
    }

    @Test
    void when_delete_order_line_ok() {
        OrderLineApi orderLineApi = new OrderLineApi();
        String result = orderLineApi.delete(1);
        Assertions.assertEquals("Deleted!", result);
    }
}
