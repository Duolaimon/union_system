package org.duol.union.service;

import org.duol.union.entity.Committee;

import java.util.List;

/**
 * @author deity
 *         17-3-25 下午3:06
 */
public interface CommitteeService {
    /**
     * 返回Committee列表数据
     * @return  Committee list
     */
    List<Committee> getCommitteeList();

    /**
     * 返回指定id的Committee
     * @param CommitteeId    用户id号
     * @return          Committee
     */
    Committee getCommitteeById(String CommitteeId);

    /**
     * 添加一个新用户
     * @param CommitteeId    新用户id号
     */
    void addCommittee(String CommitteeId);

    /**
     * 删除指定id的Committee
     * @param CommitteeId    用户id号
     */
    void deleteCommitteeById(String CommitteeId);

    /**
     * 更新指定id的密码
     * @param CommitteeId    用户id号
     * @param CommitteePass  用户新密码
     */
    void updateCommitteePassword(String CommitteeId, String CommitteePass);

    /**
     * 更新指定id的姓名
     * @param CommitteeId    用户id号
     * @param CommitteeName  用户姓名
     */
    void updateCommitteeName( String CommitteeId, String CommitteeName);

    /**
     * 更新指定id的密码和姓名
     * @param CommitteeId    用户id号
     * @param CommitteePass  用户密码
     * @param CommitteeName  用户姓名
     */
    void updateCommittee(String CommitteeId,String CommitteePass,String CommitteeName);
}
