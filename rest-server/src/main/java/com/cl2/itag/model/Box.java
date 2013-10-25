package com.cl2.itag.model;

import java.util.Date;
import java.util.List;


public class Box {

    private long id;

    private List<String> content;

    private Date creationDate;

    private Date lastUpdateDate;

    private Date wrappingDate;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Date getWrappingDate() {
        return wrappingDate;
    }

    public void setWrappingDate(Date wrappingDate) {
        this.wrappingDate = wrappingDate;
    }
}
