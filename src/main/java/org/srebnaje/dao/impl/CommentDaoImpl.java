package org.srebnaje.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;
import org.srebnaje.dao.CommentDao;
import org.srebnaje.model.Comment;
import org.srebnaje.dao.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private SessionFactory sessionFactory;

    // Метод для получения текущей сессии
    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public Comment addComment(Comment comment) throws DaoException {
        try {
            getCurrentSession().persist(comment);
            return comment;
        } catch (HibernateException e) {
            throw new DaoException("Ошибка при добавлении комментария", e);
        }
    }

    @Override
    public Comment getCommentById(Long id) throws DaoException {
        try {
            return getCurrentSession().get(Comment.class, id);
        } catch (HibernateException e) {
            throw new DaoException("Ошибка при получении комментария по ID", e);
        }
    }

    @Override
    public List<Comment> getAllComments() throws DaoException {
        try {
            return getCurrentSession().createQuery("from Comment", Comment.class).list();
        } catch (HibernateException e) {
            throw new DaoException("Ошибка при получении списка комментариев", e);
        }
    }

    @Override
    public Comment updateComment(Comment comment) throws DaoException {
        try {
            getCurrentSession().merge(comment);
            return comment;
        } catch (HibernateException e) {
            throw new DaoException("Ошибка при обновлении комментария", e);
        }
    }

    @Override
    public boolean deleteComment(Long id) throws DaoException {
        try {
            Comment comment = getCurrentSession().get(Comment.class, id);
            if (comment != null) {
                getCurrentSession().remove(comment);
                return true;
            } else {
                return false;
            }
        } catch (HibernateException e) {
            throw new DaoException("Ошибка при удалении комментария", e);
        }
    }
}
