package com.romans.pos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.romans.pos.repo.PrepedStockRepo;
import com.romans.pos.repo.StockTypeRepo;
import com.romans.pos.stock.inventory.Category;
import com.romans.pos.stock.inventory.PrepedStock;
import com.romans.pos.stock.inventory.StockFileReader;
import com.romans.pos.stock.inventory.StockFileReader.StockArranger;
import com.romans.pos.stock.inventory.StockType;

@Service
public class StockTypeService {
@Autowired private StockTypeRepo str;
@Autowired private PrepedStockRepo psr;

	public StockType save(StockType stockType){
		return str.save(stockType);
	}
	public StockType edit(int id,StockType stockType){
		StockType st = str.getOne(id);
		st.setDate(stockType.getDate());
		st.setName(stockType.getName());
		st.setWeight(stockType.getWeight());
		return str.saveAndFlush(st);
	}

	public List<StockType> getAll(){
		return str.findAll();
	}
	public StockType deleteStock(int id){
		if(str.getOne(id) != null){
			str.delete(str.getOne(id));
		}
		return null;
	}
	
	public PrepedStock issuePrepStock(int sid){
		ArrayList<PrepedStock> prep = (ArrayList<PrepedStock>) psr.findAll();
		StockType stock = str.getOne(sid);
		for(PrepedStock p : prep){
			if(p.getName().equals(stock.getName())){
				p.setWeight(p.getWeight() + stock.getWeight());
				psr.saveAndFlush(p);
				deleteStock(sid);
				return p;
			}
			else{
				return null;
			}
		}
		return null;
	}
	
	public double getStockTotalWeight(String name){
		List<StockType> items = new ArrayList<>();
		items = str.findAll();
		double sumWeight = 0;
		for(StockType s : items){   
			if(name.equals(s.getName())){
				sumWeight += s.getWeight();
			}
		}
		
		return sumWeight;
	}
	
	public int getTotalStockCount(String name){
		int count = 0;
		List<StockType> items = new ArrayList<>();
		items = str.findAll();
		for(StockType s : items){
			if(name.equals(s.getName())){
				count++;
			}
		}
		return count;
	}
	
	public List<StockType> getStockbyCategory(Category category){
		List<StockType> allStock = str.findAll();
		List<StockType> sort = new ArrayList<>();
		for(StockType st: allStock){
			for(StockArranger s : StockFileReader.getInsance().readStockNamesfromFile("C:\\Roman's Pizza  appData\\Stock\\stock.txt")){
				if(category.equals(s.getCategory())){
					sort.add(st);
				}
			}
		}
		return sort;
	}
}
