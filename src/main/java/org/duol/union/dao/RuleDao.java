package org.duol.union.dao;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.Rule;

import java.util.List;

public interface RuleDao {
    int insert(Rule record);

    int insertSelective(Rule record);

    void delete(@Param("id") int id);

    List<Rule> queryList();

    Rule queryById(@Param("id") int id);
}