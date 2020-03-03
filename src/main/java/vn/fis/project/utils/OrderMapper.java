package vn.fis.project.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.fis.project.domain.OrderDto;
import vn.fis.project.entity.Order;

public class OrderMapper {
    private static final Logger LOG = LoggerFactory.getLogger(OrderMapper.class);
    public static OrderDto map(Order order){
        OrderDto dto = new OrderDto();
        dto.setId(order.getId());
        dto.setOrderNo(order.getOrderNo());
        LOG.debug("Order {} , Order_Line: {} ", order.getOrderNo(), order.getOrderLines().size());
        return dto;
    }
}
