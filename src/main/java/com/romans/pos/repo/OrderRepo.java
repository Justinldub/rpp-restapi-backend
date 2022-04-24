package com.romans.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romans.pos.model.orders.Order;

@Repository
public interface OrderRepo  extends JpaRepository<Order,Integer>{

}
