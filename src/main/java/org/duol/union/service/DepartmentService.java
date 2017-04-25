package org.duol.union.service;

import org.apache.ibatis.annotations.Param;
import org.duol.union.entity.Department;

import java.util.List;

/**
 * @author deity
 *         17-4-16 下午1:35
 */
public interface DepartmentService {
    /**
     * 返回部门的列表
     * @return Department List
     */
    List<Department> getDepartmentList();

    /**
     * 返回指定id号的部门
     * @param departmentId 部门id号
     * @return  Department
     */
    Department getDepartmentById(@Param("departmentId") String departmentId);

    /**
     * 插入一个新的部门
     * @param departmentId          部门id号
     * @param departmentPassword    部门登录密码
     * @param departmentName        部门名字
     */
    void addDepartment(@Param("departmentId") String departmentId,
                          @Param("departmentPassword") String departmentPassword,
                          @Param("departmentName") String departmentName);

    /**
     * 删除指定id号的部门
     * @param departmentId  部门id号
     */
    void removeDepartmentById(@Param("departmentId") String departmentId);
}
