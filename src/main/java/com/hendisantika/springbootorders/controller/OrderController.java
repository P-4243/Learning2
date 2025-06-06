package com.hendisantika.springbootorders.controller;

import com.hendisantika.springbootorders.model.Orders;
import com.hendisantika.springbootorders.repository.OrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderRepo orderRepo = null;

    @GetMapping
    ResponseEntity<List<Orders>> getOrders(){
        return new ResponseEntity<>(orderRepo.findAll(), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<Orders> saveOrder(@RequestBody Orders orders){
        return new ResponseEntity<>(orderRepo.save(orders), HttpStatus.OK);
    }
}
