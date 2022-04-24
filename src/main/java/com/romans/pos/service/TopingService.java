package com.romans.pos.service;

import java.util.List;












import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romans.pos.repo.PrepedStockRepo;
import com.romans.pos.repo.TopingRepo;
import com.romans.pos.stock.inventory.PrepedStock;
import com.romans.pos.stock.inventory.Toping;
@Service
public class TopingService {
	@Autowired TopingRepo tr;
	@Autowired PrepedStockRepo psr;
	
	
	
	
	
	
	
	public Toping save(Toping toping,int pid){
		PrepedStock p = psr.getOne(pid);
		toping.setPrepedStock(p);
		toping.setName(p.getName());
		return this.tr.save(toping);
	}
	
	public Toping edit(int id,Toping toping){
		Toping t = tr.getOne(id);
		t.setName(toping.getName());
		t.setWeight(toping.getWeight());
		return this.tr.saveAndFlush(toping);
	}
	
	public List<Toping> getAll(){
		return this.tr.findAll();
	}
}
