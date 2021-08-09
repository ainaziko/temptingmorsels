package com.production.stock.controllers;

import com.production.stock.entity.AppUser;
import com.production.stock.service.AppUserService;
import com.production.stock.model.AppUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;
import java.util.Optional;

@EnableSwagger2
@RestController
@RequestMapping("/customer")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @GetMapping("/all")
    public List<AppUser> getAll(){
        return appUserService.findAll();
    }

    @GetMapping("{id}")
    public Optional<AppUser> getById(@PathVariable(name = "id") Long id){
        return appUserService.findById(id);
    }

    @PostMapping("/add")
    public AppUserModel add(@RequestBody AppUserModel model){
        appUserService.addUser(model);
        return model;
    }

    @PutMapping("edit/{id}")
    public AppUser edit(@PathVariable(name = "id") Long id, @RequestBody AppUserModel model) throws Exception {
        return appUserService.edit(id, model);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id){
        appUserService.delete(id);
        return "Deleted";
    }
}
