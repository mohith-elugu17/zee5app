package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;
import com.zee.zee5app.repo.UserRepo;
import com.zee.zee5app.repo.UserRepoImpl;

public class UserServiceImpl implements UserService {
	
	private static UserServiceImpl userService;
	public static UserServiceImpl getInstance() {
		if(userService == null) userService = new UserServiceImpl();
		return userService;
	}
	UserRepo userRepo = UserRepoImpl.getInstance();

	@Override
	public User insertUser(User user) throws UnableToGenerateIdException {
		// TODO Auto-generated method stub
		return userRepo.insertUser(user);
	}

	@Override
	public Optional<User> updateUserById(String userId, User user) throws Exception {
		// TODO Auto-generated method stub
		return userRepo.updateUserById(userId, user);
	}

	@Override
	public String deleteUserById(String userId) throws Exception {
		// TODO Auto-generated method stub
		return userRepo.deleteUserById(userId);
	}

	@Override
	public Optional<List<User>> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.getAllUsers();
	}

	@Override
	public Optional<User> getUserById(String userId) {
		// TODO Auto-generated method stub
		return userRepo.getUserById(userId);
	}

}
