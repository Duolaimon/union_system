package org.duol.union.entity;

import java.util.Date;

public class Question {
    private Integer questionId;

    private String questionName;

    private String questionContent;

    private Date questionTime;

    public Question(Integer questionId, String questionName, String questionContent, Date questionTime) {
        this.questionId = questionId;
        this.questionName = questionName;
        this.questionContent = questionContent;
        this.questionTime = questionTime;
    }

    public Question(String questionName, String questionContent) {
        this.questionName = questionName;
        this.questionContent = questionContent;
    }

    public Question() {
        super();
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName == null ? null : questionName.trim();
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent == null ? null : questionContent.trim();
    }

    public Date getQuestionTime() {
        return questionTime;
    }

    public void setQuestionTime(Date questionTime) {
        this.questionTime = questionTime;
    }
}