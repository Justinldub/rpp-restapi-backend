package com.romans.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romans.pos.model.product.Product;
import com.romans.pos.repo.PrepedStockRepo;
import com.romans.pos.repo.StockTypeRepo;
import com.romans.pos.stock.inventory.PrepedStock;
import com.romans.pos.stock.inventory.StockType;
import com.romans.pos.stock.inventory.Toping;
@Service
public class PrepedStockService {

	private @Autowired PrepedStockRepo psr;
	private @Autowired StockTypeRepo str;
	
	public PrepedStock save(PrepedStock prepedStock){
		return psr.save(prepedStock);
	}
	public PrepedStock edit(int id,PrepedStock prepedStock){
		PrepedStock ps = psr.getOne(id);
		ps.setName(prepedStock.getName());
		ps.setWeight(prepedStock.getWeight());
		return psr.saveAndFlush(ps);
	}
	public List<PrepedStock> getAll(){
		return psr.findAll();
	}
	public PrepedStock addPrepedStock(int pid,int sid){
		PrepedStock p = psr.getOne(pid);
		StockType s = str.getOne(sid);
		p.setWeight(p.getWeight()+s.getWeight());
		return psr.saveAndFlush(p);
	}
	public PrepedStock wastePrepedstock(int id, double weight){
		PrepedStock p = psr.getOne(id);
		p.setWeight(p.getWeight()-weight);
		return psr.saveAndFlush(p);
	}
	
	public void calculateWeight(Product product){
			for(Toping t : product.getToping()){
				t.getPrepedStock().setWeight(t.getPrepedStock().getWeight() - t.getWeight());
				psr.saveAndFlush(t.getPrepedStock());
			}
	}
	
}
