package org.duol.union.service;

import org.duol.union.entity.User;

import java.util.List;

/**
 * @author deity
 *         17-3-25 下午3:06
 */
public interface UserService {
    /**
     * 返回User列表数据
     * @return  User list
     */
    List<User> getUserList();

    /**
     * 返回指定id的User
     * @param userId    用户id号
     * @return          User
     */
    User getUserById(String userId);

    /**
     * 添加一个新用户
     * @param userId    新用户id号
     */
    void insertUser(String userId);

    /**
     * 删除指定id的User
     * @param userId    用户id号
     */
    void deleteUserById(String userId);

    /**
     * 更新指定id的密码
     * @param userId    用户id号
     * @param userPass  用户新密码
     */
    void updateUserPassword(String userId, String userPass);

    /**
     * 更新指定id的姓名
     * @param userId    用户id号
     * @param userName  用户姓名
     */
    void updateUserName( String userId, String userName);

    /**
     * 更新指定id的密码和姓名
     * @param userId    用户id号
     * @param userPass  用户密码
     * @param userName  用户姓名
     */
    void updateUser(String userId,String userPass,String userName);
}
