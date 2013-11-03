package com.cl2.itag.dao.impl;


import com.cl2.itag.dao.BoxesDao;
import com.cl2.itag.model.Box;
import com.cl2.itag.model.ContentElement;

import java.util.*;

public class BoxesDaoInMemoryImpl implements BoxesDao{

    private static Map<Long,Box> dataObject = new HashMap<Long,Box>();

    @Override
    public Box createBox(Box box) {
        Long nextLong = Long.valueOf(dataObject.size() + 1);
        box.setId(nextLong);
        dataObject.put(box.getId(),box);
        return box;
    }

    @Override
    public Box searchBoxById(Long id) {
        return dataObject.get(id);
    }

    @Override
    public List<Box> searchBoxesByContent(List<ContentElement> matchingContentElements) {
        Set<Box> boxesToReturn = new HashSet<Box>();
        for (Box boxUnit : dataObject.values()){
            for(ContentElement matchingContentElement : matchingContentElements){
                if(boxUnit.getContentList().containsContentElement(matchingContentElement)){
                    boxesToReturn.add(boxUnit);
                }
            }
        }
        return new ArrayList<Box>(boxesToReturn);
    }

    @Override
    public Box updateBox(Box box) {
        return dataObject.put(box.getId(),box);
    }

    @Override
    public Box deleteBox(Box box) {
        return dataObject.remove(box.getId());
    }
}
