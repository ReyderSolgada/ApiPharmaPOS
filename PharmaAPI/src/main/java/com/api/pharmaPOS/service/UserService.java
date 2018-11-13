package com.api.pharmaPOS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.pharmaPOS.entity.User;
import com.api.pharmaPOS.repository.UserRepository;

@Service

public class UserService {

	/*
	 * When Spring creates an instance of UserService, the UserRepository class is
	 * going to be injected.
	 */

	@Autowired
	private UserRepository userRepository;

	// Method to list all users

	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}

	// Method to add a new user

	public void addUser(User user) {
		userRepository.save(user);
	}

	// Method to find a user by id

	public Optional<User> getUser(int id) {
		return userRepository.findById(id);
	}

	// Method to update a user

	public void updateUser(int id, User user) {
		userRepository.save(user);
	}

	// Method to delete a user

	public void deleteUser(int id) {
		userRepository.deleteById(id);
	}

}
