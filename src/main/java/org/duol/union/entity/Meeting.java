package org.duol.union.entity;

import java.util.Date;

public class Meeting {
    private Integer meetingId;

    private String meetingTitle;

    private String meetingContent;

    private Date meetingTime;

    public Meeting(Integer meetingId, String meetingTitle, String meetingContent, Date meetingTime) {
        this.meetingId = meetingId;
        this.meetingTitle = meetingTitle;
        this.meetingContent = meetingContent;
        this.meetingTime = meetingTime;
    }

    public Meeting() {
        super();
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle == null ? null : meetingTitle.trim();
    }

    public String getMeetingContent() {
        return meetingContent;
    }

    public void setMeetingContent(String meetingContent) {
        this.meetingContent = meetingContent == null ? null : meetingContent.trim();
    }

    public Date getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(Date meetingTime) {
        this.meetingTime = meetingTime;
    }
}