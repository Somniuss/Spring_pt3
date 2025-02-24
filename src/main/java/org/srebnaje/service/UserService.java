package org.srebnaje.service;

import java.util.List;

import org.srebnaje.model.User;

public interface UserService {

	User addUser(User user) throws ServiceException;

	User getUserById(Long id) throws ServiceException;

	List<User> getAllUsers() throws ServiceException;

	User updateUser(User user) throws ServiceException;

	boolean deleteUser(Long id) throws ServiceException;

}
