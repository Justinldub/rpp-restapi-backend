package com.romans.pos.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romans.pos.model.orders.Order;
import com.romans.pos.repo.OrderRepo;






@Service
public class OrderService {
	@Autowired private OrderRepo or; 
	
	public Order save(Order order){
		return or.save(order);
	}
	public List<Order> getAll(){
		return or.findAll();
	}
	public void deleteOrder(int id){
		or.deleteById(id);
	}
	
	public Order placeOrder(Order order){	
		Order o = new  Order();
		o.setTotal_price(order.getTotal_price());;
		Order savedOrder = or.save(o);
		savedOrder.setProducts(order.getProducts());
		or.save(savedOrder);
		return  savedOrder;
	}
	
}
