package com.example.FinalSprint.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.FinalSprint.Entity.Login;
import com.example.FinalSprint.Service.LoginService;

@RestController
public class LoginController {
	@Autowired
	LoginService loginService;
	
	@GetMapping("/login")
	public Login login(@RequestHeader String email,@RequestHeader String password) {
		return loginService.login(email, password);
	}
	
	@DeleteMapping("/login")
	public String delete(@RequestHeader String email) {
		loginService.delete(email);
		return "Deleted";
	}
	
	@GetMapping("/alllogin")
	public List<Login> getAll(){
		return loginService.getAll();
	}
}
