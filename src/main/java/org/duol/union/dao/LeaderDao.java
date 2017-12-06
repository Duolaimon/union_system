package org.duol.union.dao;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.Leader;

import java.util.List;

public interface LeaderDao {
    int insert(Leader record);

    int insertSelective(Leader record);

    List<Leader> queryLeaderList();

    Leader queryLeaderById(@Param("leaderId") int leaderId);

    void insertLeader(@Param("leaderId") int leaderId, @Param("leaderPass") String leaderPassword, @Param("leaderName") String leaderName);

    void deleteLeader(@Param("leaderId") int leaderId);

    void updateLeader(@Param("leaderId") int leaderId, @Param("leaderPass") String leaderPassword, @Param("leaderName") String leaderName);
}