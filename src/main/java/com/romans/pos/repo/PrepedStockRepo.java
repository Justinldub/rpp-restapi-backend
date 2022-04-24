package com.romans.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romans.pos.stock.inventory.PrepedStock;

@Repository
public interface PrepedStockRepo extends JpaRepository<PrepedStock, Integer> {

}
