package org.duol.union.dao;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.Team;

import java.util.List;

public interface TeamDao {
    int insert(Team record);

    int insertSelective(Team record);

    void insertTeam(@Param("teamId") Integer teamId, @Param("teamPass") String teamPass, @Param("teamName") String teamName);

    void deleteTeam(@Param("teamId") Integer teamId);

    void updateTeam(@Param("teamId") Integer teamId, @Param("teamPass") String teamPass, @Param("teamName") String teamName);

    List<Team> queryTeamList();
}