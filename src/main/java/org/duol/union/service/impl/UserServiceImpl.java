package org.duol.union.service.impl;

import org.duol.union.entity.User;
import org.duol.union.dao.UserDao;
import org.duol.union.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author deity
 *         17-3-25 下午3:06
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUserList() {
        return userDao.queryUserList();
    }

    @Override
    public User getUserById(String userId) {
        return userDao.queryUserById(userId);
    }

    @Override
    public void insertUser(String userId) {
        userDao.insertUser(userId);
    }

    @Override
    public void deleteUserById(String userId) {
        userDao.deleteUserById(userId);
    }

    @Override
    public void updateUserPassword(String userId, String userPass) {
        userDao.updateUserPassword(userId, userPass);
    }

    @Override
    public void updateUserName(String userId, String userName) {
        userDao.updateUserName(userId, userName);
    }

    @Override
    public void updateUser(String userId, String userPass, String userName) {
        userDao.updateUser(userId,userPass,userName);
    }
}
