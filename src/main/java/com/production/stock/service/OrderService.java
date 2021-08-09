package com.production.stock.service;

import com.production.stock.entity.Order;
import com.production.stock.model.OrderModel;
import com.production.stock.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return (List<Order>) repository.findAll();
    }

    public Optional<Order> findById(Long id){
        return repository.findById(id);
    }

    public Order add(OrderModel model){
        Order order = new Order(model.getAppUserId(), model.getDate(), model.getPayed());
        repository.save(order);
        return order;
    }

    public Order edit(Long id, OrderModel model) throws Exception {
        return repository.findById(id)
                .map(edit -> {
                    edit.setAppUserId(model.getAppUserId());
                    edit.setDate(model.getDate());
                    edit.setPayed(model.getPayed());
                    return repository.save(edit);
                }).orElseThrow(Exception::new);
    }

    public String delete(Long id){
        repository.deleteById(id);
        return "Deleted";
    }
}
