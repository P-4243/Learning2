package com.hendisantika.springbootorders.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;

    private String productDescription;

    private double unitPrice;

    @ManyToOne
    @JoinColumn(name = "orderID")
    private OrderDetails orderDetails;

    // No-arg constructor
    public Product() {
    }

    // All-arg constructor (without ID, used for creating new products)
    public Product(String productName, String productDescription, double unitPrice, OrderDetails orderDetails) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.unitPrice = unitPrice;
        this.orderDetails = orderDetails;
    }

    // Optional full constructor with ID
    public Product(Long productId, String productName, String productDescription, double unitPrice, OrderDetails orderDetails) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.unitPrice = unitPrice;
        this.orderDetails = orderDetails;
    }

    // ======= Getters and Setters =======

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    // Optional: toString(), equals(), hashCode() — can be generated if needed
}
