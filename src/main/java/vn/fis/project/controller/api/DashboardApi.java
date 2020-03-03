package vn.fis.project.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import vn.fis.project.domain.ProductSummary;
import vn.fis.project.service.intf.OrderService;

import java.util.List;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardApi {
    @Autowired
    private OrderService orderService;

    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    @GetMapping("/total")
    @ResponseBody
    public String total() {
        return orderService.total();
    }

    @PreAuthorize("hasAuthority('ROLE_MANAGER')")
    @GetMapping("/groupByProduct")
    @ResponseBody
    public List<ProductSummary> groupByProduct() {
        return orderService.groupByProduct();
    }
}
