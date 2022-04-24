package com.romans.pos.restapi;

import java.util.List;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.romans.pos.model.orders.Order;
import com.romans.pos.model.product.Product;
import com.romans.pos.model.product.Size;
import com.romans.pos.service.OrderService;
import com.romans.pos.service.PrepedStockService;
import com.romans.pos.service.ProductService;
import com.romans.pos.service.StockTypeService;
import com.romans.pos.service.TopingService;
import com.romans.pos.service.UserService;
import com.romans.pos.stock.inventory.PrepedStock;
import com.romans.pos.stock.inventory.StockFileReader;
import com.romans.pos.stock.inventory.StockFileReader.StockArranger;
import com.romans.pos.stock.inventory.StockType;
import com.romans.pos.stock.inventory.Toping;
import com.romans.pos.users.Role;
import com.romans.pos.users.User;
import com.romans.pos.model.product.*;
@CrossOrigin
@RestController
public class AdminController {

	
	
	
	
	
	
	private static final String BASEURL = "/api";
	@Autowired private ProductService ps;
	@Autowired private TopingService ts;
	@Autowired private StockTypeService sts;
	@Autowired private PrepedStockService pss;
	@Autowired private OrderService os;
	@Autowired private UserService us;

	
	/*
	 * Enums initialization
	 -----------------------------------------------------------------------------------------------------*/
	@GetMapping(BASEURL+"/get-categories")
	public ResponseEntity<Category[]> getAllCategories(){
		return new ResponseEntity<>(Category.values(),HttpStatus.OK);
	}
	@GetMapping(BASEURL+"/get-sizes")
	public ResponseEntity<Size[]> getAllSizes(){
		return new ResponseEntity<>(Size.values(),HttpStatus.OK);
	}
	
	@GetMapping(BASEURL+"/get-roles")
	 public ResponseEntity<Role[]> getAllRoles(){
		 return new ResponseEntity<>(Role.values(),HttpStatus.OK);
	 }
	
	/*
	 * end of emun init
	 ===================================================================================================*/
	
	/*
	 * Product Service API
	 --------------------------------------------------------------------------------------------------*/
	
	@PostMapping(BASEURL+"/save-product")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product){
		return new ResponseEntity<>(ps.save(product),HttpStatus.OK);
	}
	@PutMapping(BASEURL+"/edit-product/{id}")
	public ResponseEntity<Product> editProduct(@PathVariable int id,@RequestBody Product product){
		return new ResponseEntity<>(ps.edit(id,product),HttpStatus.OK);
	}
	@GetMapping(BASEURL+"/get-all-products")
	public ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity<>(ps.getAll(),HttpStatus.OK);
	}
	@PutMapping(BASEURL+"/set-product-topings/{pid}/{tid}")
	public ResponseEntity<Product> setToppings(@PathVariable int pid,@PathVariable int tid){
		return new ResponseEntity<>(ps.addTopping(pid, tid),HttpStatus.OK);
	}
	@GetMapping(BASEURL+"/get-product-topings/{id}")
	public ResponseEntity<List<Toping>> getProductTopings(@PathVariable int id){
		return new ResponseEntity<>(ps.getProductTopings(id),HttpStatus.OK);
	}
	
	/*
	 * End of product Service
	 ===========================================================================================================*/
	
	
	
	
	
	/*
	 * Toping service API
	 --------------------------------------------------------------------------------------------------*/
	
	@PostMapping(BASEURL+"/save-toping/{pid}")
	public ResponseEntity<Toping> saveTopping(@RequestBody Toping t,@PathVariable int pid){
		return new ResponseEntity<>(ts.save(t,pid),HttpStatus.OK);
	}
	@PutMapping(BASEURL+"/edit-toping/{id}")
	public ResponseEntity<Toping> editTopping(@PathVariable int id,@RequestBody Toping t){
		return new ResponseEntity<>(ts.edit(id,t),HttpStatus.OK);
	}
	@GetMapping(BASEURL+"/get-all-topings")
	public ResponseEntity<List<Toping>> getAllToppings(){
		return new ResponseEntity<>(ts.getAll(),HttpStatus.OK);
	}
	
	
	
	/*
	 * End of Toping Service
	 =====================================================================================================*/
	
	
	
	
	
	/*
	 * Stock service API
	 -----------------------------------------------------------------------------------------------------*/
	
	@PostMapping(BASEURL+"/save-stock-type")
	public ResponseEntity<StockType> saveStockType(@RequestBody StockType s){
		return new ResponseEntity<>(sts.save(s),HttpStatus.OK);
	}
	@PutMapping(BASEURL+"/edit-stock-type/{id}")
	public ResponseEntity<StockType> editStock(@PathVariable int id,@RequestBody StockType s){
		return new ResponseEntity<>(sts.edit(id,s),HttpStatus.OK);
	}
	
	@GetMapping(BASEURL+"/get-all-stock-type")
	public ResponseEntity<List<StockType>> getAllStock(){
		return new ResponseEntity<>(sts.getAll(),HttpStatus.OK);
	}
	@DeleteMapping(BASEURL+"/delete-stock/{id}")
	public ResponseEntity<StockType> deleteStock(@PathVariable int id){
		return new ResponseEntity<>(sts.deleteStock(id),HttpStatus.MOVED_PERMANENTLY);
	}
	@GetMapping(BASEURL+"/get-stock-type-names")
	public ResponseEntity<List<StockArranger>> getStockNames(){
		return new ResponseEntity<>(StockFileReader.getInsance().readStockNamesfromFile("C:\\Roman's Pizza  appData\\Stock\\stock.txt"),HttpStatus.OK);
	}
	@PutMapping(BASEURL+"/issue-preped-stock/{sid}")
	public ResponseEntity<PrepedStock> issuePrepedStock(@PathVariable int sid){
		return new ResponseEntity<>(sts.issuePrepStock(sid),HttpStatus.OK);
	}
	/*
	 * End of Stock  service
	 ===================================================================================================*/
	
	
	
	
	
	
	/*
	 * Preped Stock Service API
	 ----------------------------------------------------------------------------------------------------*/
	
	@PostMapping(BASEURL+"/save-preped-stock")
	public ResponseEntity<PrepedStock> savePrepedStock(@RequestBody PrepedStock p){
		return new ResponseEntity<>(pss.save(p),HttpStatus.OK);
	}
	@PutMapping(BASEURL+"/edit-preped-stock")
	public ResponseEntity<PrepedStock> editPrepedStock(@PathVariable int id,@RequestBody PrepedStock p){
		return new ResponseEntity<>(pss.edit(id,p),HttpStatus.OK);
	}
	
	@GetMapping(BASEURL+"/get-all-preped-stock")
	public ResponseEntity<List<PrepedStock>> getAllPrepedStock(){
		return new ResponseEntity<>(pss.getAll(),HttpStatus.OK);
	}
	
	@PutMapping(BASEURL+"/waste-preped-stock/{id}/{weight}")
	public ResponseEntity<PrepedStock> wastePrepedStock(@PathVariable int id,@PathVariable double weight){
		return new ResponseEntity<>(pss.wastePrepedstock(id, weight),HttpStatus.OK);
	}
	/*
	 * End of Preped Stock
	 =============================================================================================================*/

	/*
	 * Orders Management API
	 -------------------------------------------------------------------------------------------------------------*/
		
	 @GetMapping(BASEURL+"/get-all-orders")
	 public ResponseEntity<List<Order>> getAllOrders(){
		 return new ResponseEntity<>(os.getAll(),HttpStatus.OK);
	 }
	 
	 @PostMapping(BASEURL+"/place-order")
	 public ResponseEntity<Order> createOrder(@RequestBody  Order order){
		 return new ResponseEntity<>(os.placeOrder(order),HttpStatus.OK);
	 }
	 
	
	/*
	 * End of orders management
	 =============================================================================================================*/

	 /*
	  * Users Management API
	  ---------------------------------------------------------------------------------------------------------------*/
	 	
	 @GetMapping(BASEURL+"/get-all-users")
	 public ResponseEntity<List<User>> getUsers(){
		 return new ResponseEntity<List<User>>(us.getUsers(),HttpStatus.OK);
	 }
	 @PostMapping(BASEURL+"/save-user")
	 public ResponseEntity<User> saveUser(@RequestBody User user){ 
		 return new ResponseEntity<User>(us.addUser(user),HttpStatus.OK);
	 }
	 @PutMapping(BASEURL+"/edit-user")
	 public ResponseEntity<User> edit(@RequestBody User user)
	 {
		 return new ResponseEntity<User>(us.edit(user),HttpStatus.OK);
	 }
	 @DeleteMapping(BASEURL+"/delete-user")
	 public ResponseEntity<User> deleteUser(int id){
		 us.delete(id);
		 return new ResponseEntity<User>(HttpStatus.OK);
	 }
	 
	 /*
	  * End of Users API
	  =================================================================================================================*/


}
