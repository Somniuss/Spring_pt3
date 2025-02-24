package org.srebnaje.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.srebnaje.dao.UserDao;
import org.srebnaje.model.User;
import org.srebnaje.dao.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	// Метод для получения текущей сессии
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User addUser(User user) throws DaoException {
		try {
			getCurrentSession().persist(user);
			return user;
		} catch (HibernateException e) {
			throw new DaoException("Ошибка при добавлении пользователя", e);
		}
	}

	@Override
	public User getUserById(Long id) throws DaoException {
		try {
			return getCurrentSession().get(User.class, id);
		} catch (HibernateException e) {
			throw new DaoException("Ошибка при получении пользователя по ID", e);
		}
	}

	@Override
	public List<User> getAllUsers() throws DaoException {
		try {
			return getCurrentSession().createQuery("from User", User.class).list();
		} catch (HibernateException e) {
			throw new DaoException("Ошибка при получении списка пользователей", e);
		}
	}

	@Override
	public User updateUser(User user) throws DaoException {
		try {
			getCurrentSession().merge(user);
			return user;
		} catch (HibernateException e) {
			throw new DaoException("Ошибка при обновлении пользователя", e);
		}
	}

	@Override
	public boolean deleteUser(Long id) throws DaoException {
		try {
			User user = getCurrentSession().get(User.class, id);
			if (user != null) {
				getCurrentSession().remove(user);
				return true;
			} else {
				return false;
			}
		} catch (HibernateException e) {
			throw new DaoException("Ошибка при удалении пользователя", e);
		}
	}
}
