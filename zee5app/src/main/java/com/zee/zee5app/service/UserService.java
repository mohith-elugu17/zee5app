package com.zee.zee5app.service;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.UnableToGenerateIdException;

public interface UserService {
	public User insertUser(User user) throws UnableToGenerateIdException;
	public Optional<User> updateUserById(String userId, User user) throws Exception;
	public String deleteUserById(String userId) throws Exception;
	public Optional<List<User>> getAllUsers();
	public Optional<User> getUserById(String userId);
}
