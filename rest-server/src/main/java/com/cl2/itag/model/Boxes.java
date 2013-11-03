package com.cl2.itag.model;

import java.util.Set;

public class Boxes {

    private Set<Box> boxes;

    public void addOrUpdateBox(Box box) {
        this.boxes.add(box);
    }

    public void deleteBox(Box box) {
        this.boxes.remove(box);
    }

}


