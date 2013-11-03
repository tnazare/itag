package com.cl2.itag.model;

import com.google.common.base.Objects;

import java.util.Date;
import java.util.List;


public class Box {

    private long id;

    private ContentElementList contentList;

    private Date creationDate;

    private Date lastUpdateDate;

    private Date wrappingDate;


    public Box(ContentElementList contentList, Date creationDate, Date lastUpdateDate, Date wrappingDate) {
        this.contentList = contentList;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.wrappingDate = wrappingDate;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("contentList", contentList)
                .add("creationDate", creationDate)
                .add("lastUpdateDate", lastUpdateDate)
                .add("wrappingDate", wrappingDate)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Box)) return false;

        Box box = (Box) o;

        if (id != box.id) return false;
        if (!contentList.equals(box.contentList)) return false;
        if (!creationDate.equals(box.creationDate)) return false;
        if (lastUpdateDate != null ? !lastUpdateDate.equals(box.lastUpdateDate) : box.lastUpdateDate != null)
            return false;
        if (wrappingDate != null ? !wrappingDate.equals(box.wrappingDate) : box.wrappingDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + contentList.hashCode();
        result = 31 * result + creationDate.hashCode();
        result = 31 * result + (lastUpdateDate != null ? lastUpdateDate.hashCode() : 0);
        result = 31 * result + (wrappingDate != null ? wrappingDate.hashCode() : 0);
        return result;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ContentElementList getContentList() {
        return contentList;
    }


    public Date getCreationDate() {
        return creationDate;
    }


    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }


    public Date getWrappingDate() {
        return wrappingDate;
    }

}
