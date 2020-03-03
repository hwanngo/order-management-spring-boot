package vn.fis.project.domain;

public class OrderDto{

    private Integer id;

    private String orderNo;

    public OrderDto() {
    }

    public OrderDto(Integer id, String orderNo) {
        this.id = id;
        this.orderNo = orderNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
