package org.duol.union.entity;

public class Department {
    private String departmentId;

    private String departmentPassword;

    private String departmentName;

    public Department(String departmentId, String departmentPassword, String departmentName) {
        this.departmentId = departmentId;
        this.departmentPassword = departmentPassword;
        this.departmentName = departmentName;
    }

    public Department() {
        super();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public String getDepartmentPassword() {
        return departmentPassword;
    }

    public void setDepartmentPassword(String departmentPassword) {
        this.departmentPassword = departmentPassword == null ? null : departmentPassword.trim();
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName == null ? null : departmentName.trim();
    }
}