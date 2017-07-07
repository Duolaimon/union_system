package org.duol.union.dao;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.Event;

import java.util.List;

public interface EventDao {
    int insert(Event record);

    int insertSelective(Event record);

    List<Event> queryEventList();

    void deleteEvent(@Param("eventId") Integer eventId);

    void insertEvent(@Param("title") String title,@Param("content") String content);

    Event queryEventById(@Param("eventId") Integer eventId);
}