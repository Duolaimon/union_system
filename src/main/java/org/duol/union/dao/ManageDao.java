package org.duol.union.dao;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.Manage;

/**
 * @author Duolaimon
 *         17-6-25 下午6:02
 */
public interface ManageDao {

    Manage queryManage(@Param("id") String id);
}
