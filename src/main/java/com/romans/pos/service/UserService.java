package com.romans.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romans.pos.repo.AddressRepo;
import com.romans.pos.repo.UserRepo;
import com.romans.pos.users.Address;
import com.romans.pos.users.User;




 
@Service
public class UserService {
	@Autowired private UserRepo ur;
	@Autowired private AddressRepo ar;
	public User addUser(User user){
		for(Address address: user.getAddress()){
			address.setUser(user);
		}
		
		return ur.save(user);
	}
	
	public User edit(User user){
		return ur.saveAndFlush(user);
	}
	
	public void delete(int id){
		ur.deleteById(id);
	}
	public List<User> getUsers(){
		return ur.findAll();
	}
}
