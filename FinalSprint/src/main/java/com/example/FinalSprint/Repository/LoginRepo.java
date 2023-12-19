package com.example.FinalSprint.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.FinalSprint.Entity.Login;

public interface LoginRepo extends JpaRepository<Login,Integer>{
	
	@Query(value = "select * from Login where email=?",nativeQuery=true)
	Login findByEmail(String email);
	
}
