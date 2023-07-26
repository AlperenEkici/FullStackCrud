package com.example.demo.bussiness.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.bussiness.abstracts.UserService;
import com.example.demo.dataAccess.abstracts.UserDao;
import com.example.demo.entities.User;
import com.example.demo.exceptions.UserNotFoundException;

@Service
public class UserManager implements UserService {

	UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public List<User> getAll() {
		return this.userDao.findAll();
	}

	@Override
	public User Add(User user) {
		return userDao.save(user);
	}

	@Override
	public User getById(Long id) {
		return userDao.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}

	@Override
	public User updateUser(Long id, User newUser) {
		User user = userDao.findById(id)
				.orElseThrow(() -> new UserNotFoundException(id));

		user.setName(newUser.getName());
		user.setUserName(newUser.getUserName());
		user.setEmail(newUser.getEmail());

		return userDao.save(user);
	}

	@Override
	public String deleteUser(Long id) {
		if (!userDao.existsById(id)) {
			throw new UserNotFoundException(id);
		}
		userDao.deleteById(id);

		return "User with id" + id + "has been deleted success";

	}

}
