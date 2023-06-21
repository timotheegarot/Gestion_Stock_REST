package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("/*")
@RestController
public class OrderController {

    @Autowired
    OrderRepo orderRepo;

    @GetMapping("/order")
    public List<Order> getTransactionList() {
        return orderRepo.findAll();
    }

    @GetMapping("/order/{orderId}")
    public Optional<Order> getOrderById(@PathVariable(name = "orderId") Long id) {
        return orderRepo.findById(id);
    }

    @PostMapping("/order")
    public Order saveOrder(@RequestBody Order Order) {
        return orderRepo.save(Order);
    }

    @DeleteMapping("/order/{orderId}")
    public void deleteOrder(@PathVariable(name = "orderId") Long id) {
        orderRepo.deleteById(id);
    }
}

