package com.romans.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romans.pos.model.product.Product;
import com.romans.pos.repo.ProductRepo;
import com.romans.pos.repo.TopingRepo;
import com.romans.pos.stock.inventory.Toping;

@Service
public class ProductService {

	
	
	
	
	@Autowired private ProductRepo pr;
	@Autowired private TopingRepo tr;
	
	public Product save(Product product){
		return pr.save(product);
	}
	public Product edit(int id,Product p){
		Product product = pr.getOne(id);
		product.setName(p.getName());
		product.setPrice(p.getPrice());
		product.setSize(p.getSize());
		product.setCategory(p.getCategory());
		return pr.saveAndFlush(product);
	}
	public List<Product> getAll(){
		return pr.findAll();
	}
	
	public Product addTopping(int pid, int tid){
		Product p = pr.getOne(pid);
		Toping t = tr.getOne(tid);
		p.getToping().add(t);
		p.setToping(p.getToping());
		
		return pr.saveAndFlush(p);
	}
	
	public List<Toping> getProductTopings(int id){
		return pr.getOne(id).getToping();
	}
	public Product getProductById(int id){
		return pr.getOne(id);
	}
	
	
} 
