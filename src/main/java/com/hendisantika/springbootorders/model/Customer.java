package com.hendisantika.springbootorders.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Customer {

    @Id
    @Column(name = "customerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String cusFirstname;
    private String cusLastname;
    private String cusEmail;
    private String cusPhoneNo;
    private String cusCity;
    private String cusProvince;
    private String cusCountry;

    @ManyToMany(cascade = CascadeType.MERGE) // ✅ REQUIRED annotation
    @JoinTable(
            name = "customer_order",
            joinColumns = @JoinColumn(name = "customerId"),
            inverseJoinColumns = @JoinColumn(name = "orderId")
    )
    private Set<Orders> orders = new HashSet<>(0);

    // No-arg constructor
    public Customer() {}

    // All-arg constructor
    public Customer(Long customerId, String cusFirstname, String cusLastname, String cusEmail, String cusPhoneNo,
                    String cusCity, String cusProvince, String cusCountry, Set<Orders> orders) {
        this.customerId = customerId;
        this.cusFirstname = cusFirstname;
        this.cusLastname = cusLastname;
        this.cusEmail = cusEmail;
        this.cusPhoneNo = cusPhoneNo;
        this.cusCity = cusCity;
        this.cusProvince = cusProvince;
        this.cusCountry = cusCountry;
        this.orders = orders;
    }

    // Custom constructor without ID
    public Customer(String cusFirstname, String cusLastname, String cusEmail, String cusPhoneNo,
                    String cusCity, String cusProvince, String cusCountry, Set<Orders> orders) {
        this.cusFirstname = cusFirstname;
        this.cusLastname = cusLastname;
        this.cusEmail = cusEmail;
        this.cusPhoneNo = cusPhoneNo;
        this.cusCity = cusCity;
        this.cusProvince = cusProvince;
        this.cusCountry = cusCountry;
        this.orders = orders;
    }

    // ======= Getters and Setters =======
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCusFirstname() {
        return cusFirstname;
    }

    public void setCusFirstname(String cusFirstname) {
        this.cusFirstname = cusFirstname;
    }

    public String getCusLastname() {
        return cusLastname;
    }

    public void setCusLastname(String cusLastname) {
        this.cusLastname = cusLastname;
    }

    public String getCusEmail() {
        return cusEmail;
    }

    public void setCusEmail(String cusEmail) {
        this.cusEmail = cusEmail;
    }

    public String getCusPhoneNo() {
        return cusPhoneNo;
    }

    public void setCusPhoneNo(String cusPhoneNo) {
        this.cusPhoneNo = cusPhoneNo;
    }

    public String getCusCity() {
        return cusCity;
    }

    public void setCusCity(String cusCity) {
        this.cusCity = cusCity;
    }

    public String getCusProvince() {
        return cusProvince;
    }

    public void setCusProvince(String cusProvince) {
        this.cusProvince = cusProvince;
    }

    public String getCusCountry() {
        return cusCountry;
    }

    public void setCusCountry(String cusCountry) {
        this.cusCountry = cusCountry;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
