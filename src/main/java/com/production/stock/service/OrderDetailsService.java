package com.production.stock.service;

import com.production.stock.entity.OrderDetails;
import com.production.stock.model.OrderDetailsModel;
import com.production.stock.repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailsService {

    @Autowired
    OrderDetailsRepository repository;

    public List<OrderDetails> findAll(){
        return (List<OrderDetails>) repository.findAll();
    }

    public Optional<OrderDetails> findById(Long id){
        return repository.findById(id);
    }


    public OrderDetails add(OrderDetailsModel model){
        OrderDetails orderDetails = new OrderDetails(model.getOrderId(),
                model.getDessertId(), model.getDessertQuantity(), model.getDessertPrice(),
                model.getDrinkId(), model.getDrinkQuantity(), model.getDessertPrice(), model.getTotal());
        repository.save(orderDetails);
        return orderDetails;
    }

    public OrderDetails edit(Long id, OrderDetailsModel model) throws Exception {
        return repository.findById(id)
                .map(edit -> {
                    edit.setOrderDetailId(model.getOrderDetailId());
                    edit.setOrder_id(model.getOrderId());
                    edit.setDessert_id(model.getDessertId());
                    edit.setDessertQuantity(model.getDessertQuantity());
                    edit.setDessertsPrice(model.getDessertPrice());
                    edit.setDrink_id(model.getDrinkId());
                    edit.setDrinkQuantity(model.getDrinkQuantity());
                    edit.setDrinksPrice(model.getDrinkPrice());
                    edit.setTotal(model.getTotal());
                    return repository.save(edit);
                }).orElseThrow(Exception::new);
    }

    public String delete(Long id){
        repository.deleteById(id);
        return "Deleted";
    }
}
/**
 * orderDetailId
 * order_id
 * dessert_id
 * dessertQuantity
 * dessertsPrice
 * drink_id
 * drinkQuantity
 * drinksPrice
 * total
 */