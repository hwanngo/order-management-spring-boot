package vn.fis.project.repository;

import vn.fis.project.domain.ProductSummary;

import java.util.List;

public interface OrderRepositoryJdbc {
    List<ProductSummary> groupByProduct();
}
