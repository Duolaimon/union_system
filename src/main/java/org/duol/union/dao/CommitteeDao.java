package org.duol.union.dao;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.Committee;

import java.util.List;

/**
 * @author deity
 *         17-3-25 下午2:12
 */
public interface CommitteeDao {

    /**
     * 返回Committee列表数据
     * @return  Committee list
     */
    List<Committee> queryCommitteeList();

    /**
     * 返回指定id的Committee
     * @param committeeId    用户id号
     * @return          Committee
     */
    Committee queryCommitteeById(@Param("committeeId") String committeeId);

    /**
     * 添加一个新用户
     * @param committeeId    新用户id号
     */
    void insertCommittee(@Param("committeeId") String committeeId);

    /**
     * 删除指定id的Committee
     * @param committeeId    用户id号
     */
    void deleteCommitteeById(@Param("committeeId") String committeeId);

    /**
     * 更新指定id的密码和姓名
     * @param committeeId    用户id号
     * @param committeePass  用户密码
     * @param committeeName  用户姓名
     */
    void updateCommittee(@Param("committeeId")String committeeId,@Param("committeePass") String committeePass, @Param("committeeName") String committeeName);
}
