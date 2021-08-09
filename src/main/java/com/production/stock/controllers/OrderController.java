package com.production.stock.controllers;

import com.production.stock.entity.Order;
import com.production.stock.model.OrderModel;
import com.production.stock.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService service;
    //getAll
    @GetMapping("/all")
    public List<Order> getAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getById(Long id){
        return service.findById(id);
    }

    @PostMapping("/add")
    public OrderModel add(OrderModel model){
        service.add(model);
        return model;
    }

    @PostMapping("/edit/{id}")
    public Order edit(Long id, OrderModel model) throws Exception {
        return service.edit(id, model);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(Long id){
        return service.delete(id);
    }
}
