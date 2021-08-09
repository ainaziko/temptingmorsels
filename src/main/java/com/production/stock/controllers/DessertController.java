package com.production.stock.controllers;

import com.production.stock.entity.Dessert;
import com.production.stock.model.DessertModel;
import com.production.stock.service.DessertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

@EnableSwagger2
@RestController
@RequestMapping("/dessert")
public class DessertController {

    @Autowired
    DessertService dessertService;

    public DessertController(DessertService dessertService) {
        this.dessertService = dessertService;
    }

    @GetMapping( "/all")
    public List<Dessert> all() {
        return dessertService.getAllDesserts();
    }

    @GetMapping("/{id}")
    public Optional<Dessert> getDessert(@PathVariable("id") Long id){
        return dessertService.getDessert(id);
    }

    @PostMapping("/add")
    public DessertModel addDessert(@RequestBody DessertModel dessert){
        dessertService.createDessert(dessert);
        return dessert;
    }

    @DeleteMapping("/{id}")
    public String deleteDessert(@PathVariable("id") Long id){
        dessertService.deleteDessert(id);
        return "deleted";
    }

    @PutMapping("/edit/{id}")
    public Dessert putDessert(@PathVariable("id") Long id, @RequestBody DessertModel dessert) throws Exception {
        return dessertService.updateDessert(id, dessert);

    }
}
