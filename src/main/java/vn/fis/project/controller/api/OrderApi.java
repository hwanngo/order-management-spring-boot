package vn.fis.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import vn.fis.project.entity.Order;
import vn.fis.project.service.intf.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderApi {
    @Autowired
    private OrderService orderService;

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER')")
    @GetMapping("/listall")
    @ResponseBody
    public List<Order> listAll() {
        return orderService.listAll();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER')")
    @GetMapping("/list")
    @ResponseBody
    public List<Order> list() {
        return orderService.list();
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_SALE')")
    @PostMapping("/create")
    public String insert(@RequestBody Order order) {
        orderService.create(order);
        return "Created!";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_SALE')")
    @PostMapping("/update")
    public String update(@RequestBody Order order) {
        orderService.update(order);
        return "Updated";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN', 'ROLE_MANAGER', 'ROLE_SALE')")
    @PostMapping("/delete")
    public String delete(@RequestParam(value = "id", defaultValue = "") Integer id) {
        orderService.deleteById(id);
        return "Deleted!";
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
