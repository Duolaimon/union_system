package org.duol.union.service.impl;

import org.duol.union.dao.DepartmentDao;
import org.duol.union.entity.Department;
import org.duol.union.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author deity
 *         17-4-16 下午1:38
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentDao departmentDao;

    @Autowired
    public DepartmentServiceImpl(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public List<Department> getDepartmentList() {
        return departmentDao.queryDepartmentList();
    }

    @Override
    public Department getDepartmentById(String departmentId) {
        return departmentDao.queryDepartmentById(departmentId);
    }

    @Override
    public void addDepartment(String departmentId, String departmentPassword, String departmentName) {
        departmentDao.insertDepartment(departmentId, departmentPassword, departmentName);
    }

    @Override
    public void removeDepartmentById(String departmentId) {
        departmentDao.deleteDepartmentById(departmentId);
    }
}
