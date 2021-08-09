package com.production.stock.controllers;

import com.production.stock.entity.SoftDrink;
import com.production.stock.model.SoftDrinkModel;
import com.production.stock.service.SoftDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

@EnableSwagger2
@RestController
@RequestMapping("drink")
public class SoftDrinkController {

    @Autowired
    SoftDrinkService softDrinkService;

    public SoftDrinkController(SoftDrinkService softDrinkService) {
        this.softDrinkService = softDrinkService;
    }

    @GetMapping("/all")
    public List<SoftDrink> getAll(){
        return softDrinkService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<SoftDrink> getById(@PathVariable("id") Long id){
        return softDrinkService.findById(id);
    }

    @PostMapping("/add")
    public SoftDrinkModel add(@RequestBody SoftDrinkModel model){
        softDrinkService.add(model);
        return model;
    }

    @PutMapping("/edit/{id}")
    public SoftDrink edit(@PathVariable("id") Long id, @RequestBody SoftDrinkModel model) throws Exception {
        return softDrinkService.edit(id, model);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return softDrinkService.delete(id);
    }

}
