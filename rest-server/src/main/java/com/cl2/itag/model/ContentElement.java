package com.cl2.itag.model;


import com.google.common.base.Objects;

public class ContentElement {

    private long id;

    private String label;

    private String description;

    public ContentElement(String label, String description) {
        this.label = label;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContentElement)) return false;

        ContentElement that = (ContentElement) o;

        if (id != that.id) return false;
        if (!description.equals(that.description)) return false;
        if (!label.equals(that.label)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + label.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("label", label)
                .add("description", description)
                .toString();
    }
}

