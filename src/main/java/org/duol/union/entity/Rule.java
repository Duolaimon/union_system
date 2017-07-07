package org.duol.union.entity;

import java.util.Date;

public class Rule {
    private Integer ruleId;

    private String ruleName;

    private String ruleContent;

    private Date ruleTime;

    public Rule(String ruleName, String ruleContent) {
        this.ruleName = ruleName;
        this.ruleContent = ruleContent;
    }

    public Rule(Integer ruleId, String ruleName, String ruleContent, Date ruleTime) {
        this.ruleId = ruleId;
        this.ruleName = ruleName;
        this.ruleContent = ruleContent;
        this.ruleTime = ruleTime;
    }

    public Rule() {
        super();
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName == null ? null : ruleName.trim();
    }

    public String getRuleContent() {
        return ruleContent;
    }

    public void setRuleContent(String ruleContent) {
        this.ruleContent = ruleContent == null ? null : ruleContent.trim();
    }

    public Date getRuleTime() {
        return ruleTime;
    }

    public void setRuleTime(Date ruleTime) {
        this.ruleTime = ruleTime;
    }
}