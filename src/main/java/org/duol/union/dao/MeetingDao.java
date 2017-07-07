package org.duol.union.dao;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.Meeting;

import java.util.List;

public interface MeetingDao {
    int insert(Meeting record);

    int insertSelective(Meeting record);

    List<Meeting> queryMeetingList();

    Meeting queryMeetingById(@Param("id") Integer id);

    void deleteMeeting(@Param("id") Integer id);

    void insertMeeting(@Param("title") String title, @Param("content") String content);
}