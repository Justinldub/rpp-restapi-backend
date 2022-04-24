package com.romans.pos.model.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.romans.pos.model.orders.Order;
import com.romans.pos.stock.inventory.Toping;







@Entity
@Table(name = "product")
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private double price;
	
	@Column
	private String size;

	@Column
	private String category;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="product_toping")
	private List<Toping> toping;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy = "products")
	private List<Order> orders;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<Toping> getToping() {
		return toping;
	}
	public void setToping(List<Toping> toping) {
		this.toping = toping;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
	
}
