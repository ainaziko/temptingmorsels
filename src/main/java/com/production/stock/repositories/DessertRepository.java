package com.production.stock.repositories;

import com.production.stock.entity.Dessert;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DessertRepository extends CrudRepository<Dessert, Long> {
}
