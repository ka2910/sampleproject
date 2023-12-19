package com.example.FinalSprint.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.FinalSprint.Entity.Products;
import com.example.FinalSprint.Service.ProductsService;


@RestController
public class ProductsController {
	@Autowired
	ProductsService productsService;
	
	@GetMapping("/product")
	public Products login(@RequestHeader String name) {
		
		return productsService.getProduct(name); 
	}
	
	@PostMapping("/product")
	public Products addProduct(@RequestBody Products product) {
		
		return productsService.addProduct(product);
	}
	
	@PutMapping("/product")
	public Products update(@RequestHeader String name , @RequestBody Products product ) {
		
		return productsService.update(name,product);
	}
	@DeleteMapping("/product")
	public String delete(@RequestHeader String name) {
		productsService.delete(name);
		return "data deleted";
	}
	
	@GetMapping("/allproducts")
	public List<Products> getAll() {
		return productsService.getAll();
	}
}
