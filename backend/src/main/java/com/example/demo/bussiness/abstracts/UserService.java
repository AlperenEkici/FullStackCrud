package com.example.demo.bussiness.abstracts;

import java.util.List;

import com.example.demo.entities.User;

public interface UserService {
	List<User> getAll();

	User Add(User user);

	User getById(Long İd);

	User updateUser(Long id, User user);

	String deleteUser(Long id);
}
