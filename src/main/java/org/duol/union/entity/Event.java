package org.duol.union.entity;

import java.util.Date;

public class Event {
    private Integer eventId;

    private String eventTitle;

    private String eventContent;

    private Date eventTime;

    public Event(Integer eventId, String eventTitle, String eventContent, Date eventTime) {
        this.eventId = eventId;
        this.eventTitle = eventTitle;
        this.eventContent = eventContent;
        this.eventTime = eventTime;
    }

    public Event() {
        super();
    }

    public Integer getEventId() {
        return eventId;
    }

    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle == null ? null : eventTitle.trim();
    }

    public String getEventContent() {
        return eventContent;
    }

    public void setEventContent(String eventContent) {
        this.eventContent = eventContent == null ? null : eventContent.trim();
    }

    public Date getEventTime() {
        return eventTime;
    }

    public void setEventTime(Date eventTime) {
        this.eventTime = eventTime;
    }
}