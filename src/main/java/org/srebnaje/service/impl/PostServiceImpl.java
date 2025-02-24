package org.srebnaje.service.impl;

import org.srebnaje.dao.PostDao;
import org.srebnaje.model.Post;
import org.srebnaje.service.PostService;
import org.srebnaje.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    @Transactional
    public Post addPost(Post post) throws ServiceException {
        try {
            return postDao.addPost(post);
        } catch (Exception e) {
            throw new ServiceException("Ошибка при добавлении поста", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Post getPostById(Long id) throws ServiceException {
        try {
            return postDao.getPostById(id);
        } catch (Exception e) {
            throw new ServiceException("Ошибка при получении поста по ID", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<Post> getAllPosts() throws ServiceException {
        try {
            return postDao.getAllPosts();
        } catch (Exception e) {
            throw new ServiceException("Ошибка при получении списка постов", e);
        }
    }

    @Override
    @Transactional
    public Post updatePost(Post post) throws ServiceException {
        try {
            return postDao.updatePost(post);
        } catch (Exception e) {
            throw new ServiceException("Ошибка при обновлении поста", e);
        }
    }

    @Override
    @Transactional
    public boolean deletePost(Long id) throws ServiceException {
        try {
            return postDao.deletePost(id);
        } catch (Exception e) {
            throw new ServiceException("Ошибка при удалении поста", e);
        }
    }
}
