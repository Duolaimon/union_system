package org.duol.union.dao;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.Organization;

import java.util.List;

public interface OrganizationDao {
    int insert(Organization record);

    int insertSelective(Organization record);

    void delete(@Param("id") int id);

    List<Organization> queryList();

    Organization queryById(@Param("id") int id);
}