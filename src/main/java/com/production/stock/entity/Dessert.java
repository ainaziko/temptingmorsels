package com.production.stock.entity;


import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Dessert {
    @Id
    @SequenceGenerator(
            name = "dessert_sequence",
            sequenceName = "dessert_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "dessert_sequence"
    )
    private Long id;
    private String name;
    private String description;
    private String imgPath;
    private double price;

    public Dessert(String name, String description, String imgPath, double price) {
        this.name = name;
        this.description = description;
        this.imgPath = imgPath;
        this.price = price;
    }
}
