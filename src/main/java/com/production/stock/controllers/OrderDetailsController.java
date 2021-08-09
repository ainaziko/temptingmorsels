package com.production.stock.controllers;

import com.production.stock.entity.OrderDetails;
import com.production.stock.model.OrderDetailsModel;
import com.production.stock.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

@EnableSwagger2
@RestController
@RequestMapping("/orderdetails")
public class OrderDetailsController {

    @Autowired
    OrderDetailsService service;

    @GetMapping("/all")
    public List<OrderDetails> getAll(){
        return service.findAll();
    }

    @GetMapping("{id}")
    public Optional<OrderDetails> getById(Long id){
        return service.findById(id);
    }

    @PostMapping("/add")
    public OrderDetailsModel add(OrderDetailsModel model){
        service.add(model);
        return model;
    }
    @PutMapping("/edit/{id}")
    public OrderDetails edit(Long id, OrderDetailsModel model) throws Exception {
        return service.edit(id, model);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(Long id){
        return service.delete(id);
    }
}
