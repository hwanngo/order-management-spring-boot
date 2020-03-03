package vn.fis.project.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import vn.fis.project.domain.ProductSummary;
import vn.fis.project.repository.OrderRepositoryJdbc;

import java.util.List;

public class OrderRepositoryJdbcImpl implements OrderRepositoryJdbc {
    static final Logger LOG = LoggerFactory
            .getLogger(OrderRepositoryJdbcImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ProductSummary> groupByProduct() {
        return jdbcTemplate.query(
                "select product, sum(quantity) as quantity, " +
                        "sum(amount) as amount from order_line group " +
                        "by product order by product"
                ,(res, i) -> {
                    return new ProductSummary(res.getString("product")
                            , res.getInt("quantity")
                            , res.getDouble("amount"));
                });
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
