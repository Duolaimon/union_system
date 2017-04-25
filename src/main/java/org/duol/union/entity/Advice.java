package org.duol.union.entity;

import java.util.Date;

/**
 * @author deity
 *         17-3-25 下午1:49
 */
public class Advice {
    private Integer adviceId;

    private String title;

    private String adviceContent;

    private Date adviceTime;

    private String userId;

    private Integer adviceState;

    private Integer count;

    private String departmentId;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getAdviceId() {
        return adviceId;
    }


    public void setAdviceId(Integer adviceId) {
        this.adviceId = adviceId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdviceContent() {
        return adviceContent;
    }

    public void setAdviceContent(String adviceContent) {
        this.adviceContent = adviceContent;
    }

    public Date getAdviceTime() {
        return adviceTime;
    }

    public void setAdviceTime(Date adviceTime) {
        this.adviceTime = adviceTime;
    }

    public Integer getAdviceState() {
        return adviceState;
    }

    public void setAdviceState(Integer adviceState) {
        this.adviceState = adviceState;
    }
}
