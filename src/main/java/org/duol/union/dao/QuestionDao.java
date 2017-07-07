package org.duol.union.dao;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.Question;

import java.util.List;

public interface QuestionDao {
    int insert(Question record);

    int insertSelective(Question record);

    void delete(@Param("id") int id);

    List<Question> queryList();

    Question queryById(@Param("id") int id);
}