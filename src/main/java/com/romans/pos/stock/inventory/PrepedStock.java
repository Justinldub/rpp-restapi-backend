package com.romans.pos.stock.inventory;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "preped_stock")
@JsonIdentityInfo(generator =ObjectIdGenerators.PropertyGenerator.class,property="id")
public class PrepedStock {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column
	private String name;
	@Column
	private double weight;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="prepedStock")
	private Set<Toping> topping;
	
	public PrepedStock() {
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
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public Set<Toping> getTopping() {
		return topping;
	}
	public void setTopping(Set<Toping> topping) {
		this.topping = topping;
	}
	
}
