package com.example.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Status;
import com.example.demo.Model.User;
import com.example.demo.dao.UserRepo;

@RestController
public class UserController {

	@Autowired
	UserRepo repo;
	
	@PostMapping(path="/user/register")  //Okay...
	public Status registerUser(User newUser) {
		repo.save(newUser);
		return Status.SUCCESS;
	}
	
	@GetMapping(path = "/userAll")
	public List<User> getAllUser() {
		List<User> alluser = repo.findAll();
		return alluser;
	}
	
	@GetMapping(path="/user/{id}")
	public Optional<User> getUserById(@PathVariable int id){
		 return repo.findById(id);
	}
	
}
