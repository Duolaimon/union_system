package org.duol.union.dao;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.Reply;

import java.util.List;

public interface ReplyDao {
    int insert(Reply record);

    int insertSelective(Reply record);

    List<Reply> queryReplyList();

    Reply queryReplyById(@Param("id") Integer id);

    void deleteReply(@Param("id") Integer id);
}