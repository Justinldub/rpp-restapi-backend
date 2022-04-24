package com.romans.pos.stock.inventory;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.romans.pos.model.product.Product;

@Entity
@Table(name = "toping")
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class,property="id")
public class Toping {
	
	
	
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private String size;
	@Column
	private double weight;
	@JsonIgnore()
	@ManyToMany(cascade = CascadeType.PERSIST, mappedBy="toping")
	private List<Product> products;
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "preped_stock_id")
	private PrepedStock prepedStock;
	public Toping() {
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
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public PrepedStock getPrepedStock() {
		return prepedStock;
	}
	public void setPrepedStock(PrepedStock prepedStock) {
		this.prepedStock = prepedStock;
	}

	
}
