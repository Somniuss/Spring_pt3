package org.srebnaje.service.impl;

import org.srebnaje.dao.UserDao;
import org.srebnaje.model.User;
import org.srebnaje.service.UserService;
import org.srebnaje.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public User addUser(User user) throws ServiceException {
        try {
            return userDao.addUser(user);
        } catch (Exception e) {
            throw new ServiceException("Ошибка при добавлении пользователя", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) throws ServiceException {
        try {
            return userDao.getUserById(id);
        } catch (Exception e) {
            throw new ServiceException("Ошибка при получении пользователя по ID", e);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() throws ServiceException {
        try {
            return userDao.getAllUsers();
        } catch (Exception e) {
            throw new ServiceException("Ошибка при получении списка пользователей", e);
        }
    }

    @Override
    @Transactional
    public User updateUser(User user) throws ServiceException {
        try {
            return userDao.updateUser(user);
        } catch (Exception e) {
            throw new ServiceException("Ошибка при обновлении пользователя", e);
        }
    }

    @Override
    @Transactional
    public boolean deleteUser(Long id) throws ServiceException {
        try {
            return userDao.deleteUser(id);
        } catch (Exception e) {
            throw new ServiceException("Ошибка при удалении пользователя", e);
        }
    }
}
