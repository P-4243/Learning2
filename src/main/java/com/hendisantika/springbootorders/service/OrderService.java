package com.hendisantika.springbootorders.service;

import com.hendisantika.springbootorders.model.Customer;
import com.hendisantika.springbootorders.model.Orders;
import com.hendisantika.springbootorders.model.Product;
import com.hendisantika.springbootorders.repository.CustomerRepo;
import com.hendisantika.springbootorders.repository.OrderRepo;
import com.hendisantika.springbootorders.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerRepo customerRepository = null;
    private final ProductRepository productRepository = null;
    private final OrderRepo orderRepository = null;

    public Iterable<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public List<Orders> findAllOrders() {
        return orderRepository.findAll();
    }
}
