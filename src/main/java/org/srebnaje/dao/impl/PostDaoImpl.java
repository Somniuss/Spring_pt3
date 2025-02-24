package org.srebnaje.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.srebnaje.dao.PostDao;
import org.srebnaje.model.Post;
import org.srebnaje.dao.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDaoImpl implements PostDao {

	@Autowired
	private SessionFactory sessionFactory;

	// Метод для получения текущей сессии
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Post addPost(Post post) throws DaoException {
		try {
			getCurrentSession().persist(post);
			return post;
		} catch (HibernateException e) {
			throw new DaoException("Ошибка при добавлении поста", e);
		}
	}

	@Override
	public Post getPostById(Long id) throws DaoException {
		try {
			return getCurrentSession().get(Post.class, id);
		} catch (HibernateException e) {
			throw new DaoException("Ошибка при получении поста по ID", e);
		}
	}

	@Override
	public List<Post> getAllPosts() throws DaoException {
		try {
			return getCurrentSession().createQuery("from Post", Post.class).list();
		} catch (HibernateException e) {
			throw new DaoException("Ошибка при получении всех постов", e);
		}
	}

	@Override
	public Post updatePost(Post post) throws DaoException {
		try {
			getCurrentSession().merge(post);
			return post;
		} catch (HibernateException e) {
			throw new DaoException("Ошибка при обновлении поста", e);
		}
	}

	@Override
	public boolean deletePost(Long id) throws DaoException {
		try {
			Post post = getCurrentSession().get(Post.class, id);
			if (post != null) {
				getCurrentSession().remove(post);
				return true;
			} else {
				return false;
			}
		} catch (HibernateException e) {
			throw new DaoException("Ошибка при удалении поста", e);
		}
	}
}
