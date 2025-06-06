package com.hendisantika.springbootorders.controller;

import com.hendisantika.springbootorders.model.Orders;
import com.hendisantika.springbootorders.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequiredArgsConstructor
@Slf4j
@RequestMapping("orders")
@Controller
public class OrderWebController {
    private final OrderService orderService = new OrderService();

    @GetMapping("/create")
    public String createOrder(Model model) {
        model.addAttribute("customers", orderService.findAllCustomers());
        model.addAttribute("products", orderService.findAllProducts());
        model.addAttribute("order", new Orders());
        return "order/order_add";
    }

    @PostMapping("/insert")
    public String insertOrder(Model model, Orders order) {
        // Save operations ..
        return "order-view";
    }
}
