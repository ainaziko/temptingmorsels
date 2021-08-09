package com.production.stock.service;

import com.production.stock.entity.SoftDrink;
import com.production.stock.model.SoftDrinkModel;
import com.production.stock.repositories.SoftDrinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SoftDrinkService {

    @Autowired
    private SoftDrinkRepository softDrinkRepository;

    public List<SoftDrink> findAll(){
        return (List<SoftDrink>) softDrinkRepository.findAll();
    }

    public Optional<SoftDrink> findById(Long id){
        return softDrinkRepository.findById(id);
    }

    public SoftDrink add(SoftDrinkModel model){
        SoftDrink softDrink = new SoftDrink(model.getName(), model.getDescription(), model.getImgPath(), model.getPrice());
        return softDrinkRepository.save(softDrink);
    }

    public SoftDrink edit(Long id, SoftDrinkModel model) throws Exception {
        return softDrinkRepository.findById(id)
                .map(edit -> {
                    edit.setName(model.getName());
                    edit.setDescription(model.getDescription());
                    edit.setImgPath(model.getImgPath());
                    edit.setPrice(model.getPrice());
                    return softDrinkRepository.save(edit);
                }).orElseThrow(Exception::new);
    }

    public String delete(Long id){
        softDrinkRepository.deleteById(id);
        return "Deleted";
    }
}
