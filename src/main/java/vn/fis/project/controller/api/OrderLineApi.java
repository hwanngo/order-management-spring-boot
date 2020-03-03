package vn.fis.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.fis.project.entity.OrderLine;
import vn.fis.project.service.intf.OrderLineService;

@RestController
@RequestMapping("/api/order/orderline")
public class OrderLineApi {
    @Autowired
    private OrderLineService orderLineService;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_SALE')")
    @PostMapping("/add")
    public String add(@RequestBody OrderLine orderLine) {
        orderLineService.add(orderLine);
        return "Added!";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_SALE')")
    @PostMapping("/update")
    public String update(@RequestBody OrderLine orderLine) {
        orderLineService.update(orderLine);
        return "Updated!";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_SALE')")
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id", defaultValue = "") Integer id) {
        orderLineService.deleteById(id);
        return "Deleted!";
    }

    public OrderLineService getOrderLineService() {
        return orderLineService;
    }

    public void setOrderLineService(OrderLineService orderLineService) {
        this.orderLineService = orderLineService;
    }
}
