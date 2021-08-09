package com.production.stock.repositories;

import com.production.stock.entity.SoftDrink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoftDrinkRepository extends CrudRepository<SoftDrink, Long> {
}
