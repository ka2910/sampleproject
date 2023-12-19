package com.example.FinalSprint.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.FinalSprint.Entity.Products;


public interface ProductsRepo extends JpaRepository<Products,Integer>
{
	
	@Query(value = "select * from Products where name=?",nativeQuery=true)
	Products findByName(String name);
	
}
