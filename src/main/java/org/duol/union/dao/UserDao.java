package org.duol.union.dao;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.User;

import java.util.List;

/**
 * @author deity
 *         17-3-25 下午2:12
 */
public interface UserDao {

    /**
     * 返回User列表数据
     * @return  User list
     */
    List<User> queryUserList();

    /**
     * 返回指定id的User
     * @param userId    用户id号
     * @return          User
     */
    User queryUserById(@Param("userId") String userId);

    /**
     * 添加一个新用户
     * @param userId    新用户id号
     * @return      添加用户是否成功
     */
    boolean insertUser(@Param("userId") String userId);

    /**
     * 删除指定id的User
     * @param userId    用户id号
     */
    void deleteUserById(@Param("userId") String userId);

    /**
     * 更新指定id的密码
     * @param userId    用户id号
     * @param userPass  用户新密码
     */
    void updateUserPassword(@Param("userId") String userId, @Param("userPass") String userPass);

    /**
     * 更新指定id的姓名
     * @param userId    用户id号
     * @param userName  用户姓名
     */
    void updateUserName(@Param("userId") String userId, @Param("userName") String userName);

    /**
     * 更新指定id的密码和姓名
     * @param userId    用户id号
     * @param userPass  用户密码
     * @param userName  用户姓名
     */
    void updateUser(@Param("userId")String userId,@Param("userPass") String userPass, @Param("userName") String userName);
}
