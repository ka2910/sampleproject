package com.example.FinalSprint.Service;

import java.util.List;

import com.example.FinalSprint.Entity.Products;

public interface ProductsService {
	public Products getProduct(String name);
	public Products addProduct(Products product);
	public Products update(String name,Products product);
	public void delete(String name);
	public List<Products> getAll();
}

