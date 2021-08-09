package com.production.stock.model;

import com.production.stock.entity.Dessert;
import com.production.stock.entity.Order;
import com.production.stock.entity.SoftDrink;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsModel {

    private Long orderDetailId;
    private Order orderId;
    private Dessert dessertId;
    private int dessertQuantity;
    private double dessertPrice;
    private SoftDrink drinkId;
    private int drinkQuantity;
    private double drinkPrice;
    private double total;

    public OrderDetailsModel(Order orderId, Dessert dessertId, int dessertQuantity, double dessertPrice, SoftDrink drinkId, int drinkQuantity, double drinkPrice, double total) {
        this.orderId = orderId;
        this.dessertId = dessertId;
        this.dessertQuantity = dessertQuantity;
        this.dessertPrice = dessertPrice;
        this.drinkId = drinkId;
        this.drinkQuantity = drinkQuantity;
        this.drinkPrice = drinkPrice;
        this.total = total;
    }
    
}
