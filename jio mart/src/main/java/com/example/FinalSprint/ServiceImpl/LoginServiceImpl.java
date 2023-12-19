package com.example.FinalSprint.ServiceImpl;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.FinalSprint.Entity.Login;
import com.example.FinalSprint.Exception.ResourceNotFoundException;
import com.example.FinalSprint.Repository.LoginRepo;
import com.example.FinalSprint.Service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginRepo loginRepo;
	
	@Override
	public Login login(String email,String password) {
		Login L = loginRepo.findByEmail(email);
		
		if(L!=null) {
			if(L.getPassword().equals(password)) {
				return L;
			}
			else {
				throw new ResourceNotFoundException();
			}
		}
		else {
			throw new ResourceNotFoundException();
		}
				
	}
	
	/*
	 @Override
	 public Login addLogin(Login login){
		return loginRepo.save(login);
	}
	public Login update(String email,Login login) {
		Login L1=loginRepo.findByEmail(email);
		if(L1!=null)
		{
			L1.setUsername(login.getUsername());
			L1.setPassword(login.getPassword());
		return loginRepo.save(L1);
		}
		else {
			return new ResourceNotFoundException();
		}
	}*/
	@Override
	public void delete(String email)
	{
		Login L2=loginRepo.findByEmail(email);
		
		if(L2!=null) {
			loginRepo.delete(L2);
		}
		else {
			throw new ResourceNotFoundException();
		}
	}
	
	@Override
	public List<Login> getAll() {
		return (List<Login>) loginRepo.findAll();
	}
}
