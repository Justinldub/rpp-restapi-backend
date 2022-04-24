package com.romans.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romans.pos.model.product.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

}
