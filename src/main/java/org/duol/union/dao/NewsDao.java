package org.duol.union.dao;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.News;

import java.util.List;

public interface NewsDao {
    int insert(News record);

    int insertSelective(News record);

    List<News> queryNewsList();

    News queryNewsById(@Param("id") Integer id);

    void deleteNews(@Param("id") Integer id);

    void insertNews(@Param("title") String title, @Param("content") String content);
}