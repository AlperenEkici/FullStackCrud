package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.bussiness.abstracts.UserService;
import com.example.demo.bussiness.concretes.UserManager;
import com.example.demo.dataAccess.abstracts.UserDao;
import com.example.demo.entities.User;
import com.example.demo.exceptions.UserNotFoundException;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	UserService userService;

	@Autowired
	public UserController(UserService userservice) {
		this.userService = userservice;
	}

	@GetMapping("/getAll")
	public List<User> getAll() {
		return this.userService.getAll();
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable Long id) {
		return userService.getById(id);
	}

	@PostMapping("/add")
	public User Add(@RequestBody User user) {
		return userService.Add(user);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User newUser) {
		return userService.updateUser(id, newUser);
	}

	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);

	}

}
