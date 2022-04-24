package com.romans.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romans.pos.stock.inventory.Toping;

@Repository
public interface TopingRepo extends JpaRepository<Toping,Integer> {

}
