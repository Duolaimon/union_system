package org.duol.union.entity;

import java.util.Date;

public class Organization {
    private Integer organizationId;

    private String eorganizationName;

    private String organizationContent;

    private Date organizationTime;

    public Organization(Integer organizationId, String eorganizationName, String organizationContent, Date organizationTime) {
        this.organizationId = organizationId;
        this.eorganizationName = eorganizationName;
        this.organizationContent = organizationContent;
        this.organizationTime = organizationTime;
    }

    public Organization(String eorganizationName, String organizationContent) {
        this.eorganizationName = eorganizationName;
        this.organizationContent = organizationContent;
    }

    public Organization() {
        super();
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getEorganizationName() {
        return eorganizationName;
    }

    public void setEorganizationName(String eorganizationName) {
        this.eorganizationName = eorganizationName == null ? null : eorganizationName.trim();
    }

    public String getOrganizationContent() {
        return organizationContent;
    }

    public void setOrganizationContent(String organizationContent) {
        this.organizationContent = organizationContent == null ? null : organizationContent.trim();
    }

    public Date getOrganizationTime() {
        return organizationTime;
    }

    public void setOrganizationTime(Date organizationTime) {
        this.organizationTime = organizationTime;
    }
}