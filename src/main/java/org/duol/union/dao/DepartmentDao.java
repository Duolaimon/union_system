package org.duol.union.dao;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.Department;

import java.util.List;

/**
 * @author deity
 *         17-4-16 下午1:19
 */
public interface DepartmentDao {
    /**
     * 返回部门的列表
     * @return Department List
     */
    List<Department> queryDepartmentList();

    /**
     * 返回指定id号的部门
     * @param departmentId 部门id号
     * @return  Department
     */
    Department queryDepartmentById(@Param("departmentId") String departmentId);

    /**
     * 插入一个新的部门
     * @param departmentId          部门id号
     * @param departmentPassword    部门登录密码
     * @param departmentName        部门名字
     */
    void insertDepartment(@Param("departmentId") String departmentId,
                          @Param("departmentPassword") String departmentPassword,
                          @Param("departmentName") String departmentName);

    /**
     * 删除指定id号的部门
     * @param departmentId  部门id号
     */
    void deleteDepartmentById(@Param("departmentId") String departmentId);
}
