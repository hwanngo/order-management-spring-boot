package vn.fis.project.domain;

public class ProductSummary {
    private String product;
    int quantity;
    private double totalAmount;

    public ProductSummary() {
        super();
    }

    public ProductSummary(String product, int quantity, double totalAmount) {
        this.product = product;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
