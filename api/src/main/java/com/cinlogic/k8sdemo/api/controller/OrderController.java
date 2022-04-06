package com.cinlogic.k8sdemo.api.controller;

import com.cinlogic.k8sdemo.api.model.Order;
import com.cinlogic.k8sdemo.api.repository.OrderRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.util.List;

@RestController
public class OrderController {

    private final OrderRepository orderRepository;

    OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping("/orders")
    List<Order> getOrders() {
        return this.orderRepository.findAll();
    }

    @GetMapping("/orders/{id}")
    Order getOrder(@PathVariable int id) {
        return this.orderRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/orders")
    Order addOrder(@RequestBody Order order) {
        order.setCreatedOn(Instant.now());
        order.getLines().forEach(line -> line.setOrder(order));
        return this.orderRepository.save(order);
    }

    @DeleteMapping("/orders/{id}")
    void deleteOrder(@PathVariable int id) {
        try {
            this.orderRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
