package org.srebnaje.service;

import java.util.List;

import org.srebnaje.model.Post;

public interface PostService {

	Post addPost(Post post) throws ServiceException;

	Post getPostById(Long id) throws ServiceException;

	List<Post> getAllPosts() throws ServiceException;

	Post updatePost(Post post) throws ServiceException;

	boolean deletePost(Long id) throws ServiceException;

}
