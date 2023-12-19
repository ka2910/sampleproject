package com.example.FinalSprint.Service;

import java.util.List;

import com.example.FinalSprint.Entity.Login;

public interface LoginService {
	public Login login(String email,String password);
	//public Login addLogin(Login login);
	//public Login update(String email,Login login);
	public void delete(String email);
	public List<Login> getAll();
}
