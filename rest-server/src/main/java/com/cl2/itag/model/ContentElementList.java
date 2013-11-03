package com.cl2.itag.model;


import java.util.ArrayList;
import java.util.List;

public class ContentElementList {

    private List<ContentElement> internalContents;

    public ContentElementList() {
        this.internalContents = new ArrayList<ContentElement>();
    }

    public void addContentElement(ContentElement element) {
        this.internalContents.add(element);
    }

    public void removeContentElement(ContentElement element) {
        this.internalContents.remove(element);
    }

    public void updateContentElement(ContentElement element){
        this.internalContents.remove(element);
        this.internalContents.add(element);
    }

    public boolean containsContentElement(ContentElement element){
        for(ContentElement internalElement : internalContents){
            if(element.equals(internalElement))
                  return true;
        }
        return false;
    }

    public List<ContentElement> getItems(){
        return this.internalContents;
    }


}
