package org.srebnaje.dao;

import org.srebnaje.model.Post;
import java.util.List;

public interface PostDao {
	
	Post addPost(Post post)throws DaoException;

	Post getPostById(Long id)throws DaoException;

	List<Post> getAllPosts()throws DaoException;

	Post updatePost(Post post)throws DaoException;

	boolean deletePost(Long id)throws DaoException;
}
