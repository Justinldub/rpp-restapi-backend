package com.romans.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romans.pos.users.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{

}
