package com.hendisantika.springbootorders.controller;

import com.hendisantika.springbootorders.model.Customer;
import com.hendisantika.springbootorders.repository.CustomerRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("customers")
public class CustomerWebController {

    private final CustomerRepo customerRepo;

    // Constructor injection — no Lombok
    public CustomerWebController(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GetMapping("/list")
    public String listCustomer(Model model) {
        Iterable<Customer> customers = customerRepo.findAll();
        model.addAttribute("customers", customers);
        return "customer/customer_list";
    }

    @GetMapping("/create")
    public String showCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/customer_add";
    }

    @PostMapping("/create")
    public String addCustomer(Model model, Customer customer) {
        model.addAttribute("customer", customerRepo.save(customer));
        return "redirect:/customers/list";
    }

    @GetMapping("/edit/{id}")
    public String editFormCustomer(@PathVariable Long id, Model model) {
        Customer customer = customerRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer Id: " + id));
        model.addAttribute("customer", customer);
        return "customer/customer_add";
    }

    @GetMapping("/hapus/{id}")
    public String hapusCustomer(@PathVariable Long id) {
        customerRepo.deleteById(id);
        return "redirect:/customers/list";
    }
}
