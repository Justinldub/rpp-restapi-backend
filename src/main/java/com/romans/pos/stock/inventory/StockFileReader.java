package com.romans.pos.stock.inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StockFileReader {
	static final StockFileReader INSANCE = new StockFileReader();

	public static StockFileReader getInsance() {
		return INSANCE;
	}
	
	
	
	public class StockArranger{
		private String name;
		private Category category;
		public StockArranger(String name, Category category) {
			super();
			this.name = name;
			this.category = category;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		
	}
	public List<StockArranger> readStockNamesfromFile(String filename){
		
		List<StockArranger> names = new ArrayList<>();
		File file = new File(filename);
		Scanner fileIn = null;
		if(file.exists()){
			try {
				fileIn = new Scanner(file);
				String line = "";
				while(fileIn.hasNext()){
					line = fileIn.nextLine();
					StringTokenizer str=new StringTokenizer(line,"\t");
					names.add(new StockArranger(str.nextToken(),Category.valueOf(str.nextToken())));
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally{
				fileIn.close();
			}
		}
		else{
			
		}
		System.out.println(names.size());
		return names;
		
	}
	
	
	
	
}
