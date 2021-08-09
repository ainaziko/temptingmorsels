package com.production.stock.service;

import com.production.stock.entity.Dessert;
import com.production.stock.model.DessertModel;
import com.production.stock.repositories.DessertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DessertService {

    @Autowired
    private DessertRepository dessertRepository;

    public List<Dessert> getAllDesserts() {
        return (List<Dessert>) dessertRepository.findAll();
    }

    public Optional<Dessert> getDessert(Long id){
        return dessertRepository.findById(id);
    }

    public void deleteDessert(Long id){
        dessertRepository.deleteById(id);
    }

    public Dessert createDessert(DessertModel model){
        Dessert dessert = new Dessert(model.getName(), model.getDescription(), model.getImgPath(), model.getPrice());
        return dessertRepository.save(dessert);
    }

    public Dessert updateDessert(Long id, DessertModel model) throws Exception{
        return dessertRepository.findById(id)
                .map(updateDessert -> {
                    updateDessert.setName(model.getName());
                    updateDessert.setDescription(model.getDescription());
                    updateDessert.setImgPath(model.getImgPath());
                    updateDessert.setPrice(model.getPrice());
                    return dessertRepository.save(updateDessert);
                }).orElseThrow( Exception::new);
    }
}
