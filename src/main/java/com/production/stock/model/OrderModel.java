package com.production.stock.model;


import com.production.stock.entity.AppUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {

    private Long id;
    private AppUser appUserId;
    private LocalDateTime date;
    private int payed;
}
