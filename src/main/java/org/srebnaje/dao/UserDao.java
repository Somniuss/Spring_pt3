package org.srebnaje.dao;

import org.srebnaje.model.User;
import java.util.List;

public interface UserDao {
	
	User addUser(User user)throws DaoException;

	User getUserById(Long id)throws DaoException;

	List<User> getAllUsers()throws DaoException;

	User updateUser(User user)throws DaoException;

	boolean deleteUser(Long id)throws DaoException;
}
