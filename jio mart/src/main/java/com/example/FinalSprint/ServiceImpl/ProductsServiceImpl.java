package com.example.FinalSprint.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.FinalSprint.Entity.Products;
import com.example.FinalSprint.Exception.ResourceNotFoundException;
import com.example.FinalSprint.Repository.ProductsRepo;
import com.example.FinalSprint.Service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService{
	@Autowired
	ProductsRepo productsRepo;
	
	@Override
	public Products getProduct(String name) {
		Products s = productsRepo.findByName(name);
		 
		 if(s!=null) {
				 return s; 
		 }else {
			 throw new ResourceNotFoundException();
		 }
	}
	
	@Override
	public Products addProduct(Products product) {
		return  productsRepo.save(product);
	}
	
	@Override
	public Products update(String name,Products product) {
		Products s1 = productsRepo.findByName(name);
		
		if(s1!=null) {
			s1.setCategory(product.getCategory());   // old to new set
			s1.setPrice(product.getPrice());
			s1.setDescription(product.getDescription());
			s1.setUrl(product.getUrl());
		return productsRepo.save(s1);
		} 
		else 
		{
			throw new ResourceNotFoundException();
		} 
	}
	
	@Override
	public void delete(String name) {
		Products s2 = productsRepo.findByName(name);

		if(s2!=null) {
			productsRepo.delete(s2);
		}
		else {
			throw new ResourceNotFoundException();
		}
	}
	
	@Override
	public List<Products> getAll(){
		return (List<Products>) productsRepo.findAll();
	}
}

