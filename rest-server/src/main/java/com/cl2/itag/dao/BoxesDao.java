package com.cl2.itag.dao;


import com.cl2.itag.model.Box;
import com.cl2.itag.model.ContentElement;

import java.util.List;
import java.util.Map;

public interface BoxesDao {




    public Box createBox(Box box);

    public Box searchBoxById(Long id);

    public List<Box> searchBoxesByContent(List<ContentElement> matchingContent);

    public Box updateBox(Box box);

    public Box deleteBox(Box box) ;

}
