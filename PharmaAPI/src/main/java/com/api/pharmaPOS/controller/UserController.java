package com.api.pharmaPOS.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.api.pharmaPOS.entity.User;
import com.api.pharmaPOS.service.UserService;

@RestController

public class UserController {

	// Dependency injection

	@Autowired
	private UserService userService;

	// Method to get all users

	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	// Method to get users by id

	@RequestMapping("/users/{id}")
	public Optional<User> getUser(@PathVariable int id) {
		return userService.getUser(id);
	}

	// Method to add an user

	@RequestMapping(method = RequestMethod.POST, value = "/users")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}

	// Method to update an user

	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	public void updateUser(@RequestBody User user, @PathVariable int id) {
		userService.updateUser(id, user);
	}

	// Method to delete an user

	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
	}

}
