package com.cl2.itag.model;


import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.assertions.Fail.fail;

public class ContentElementTest {

    @Test
    public void should_Equals_Correctly(){
        ContentElement elemnt1 = new ContentElement("label","description");
        elemnt1.setId(1l);
        ContentElement elemnt2 = new ContentElement("label","description");
        elemnt2.setId(1l);
        ContentElement elemnt3 = new ContentElement("label","description");
        elemnt2.setId(3l);
        ContentElement elemnt4 = new ContentElement("label1","description");
        elemnt2.setId(1l);
        ContentElement elemnt5 = new ContentElement("label","description1");
        elemnt2.setId(1l);

        assertThat(elemnt1).isEqualTo(elemnt2);
        assertThat(elemnt1).isNotEqualTo(elemnt3);
        assertThat(elemnt1).isNotEqualTo(elemnt4);
        assertThat(elemnt1).isNotEqualTo(elemnt5);


    }

    @Test
    public void should_HashCode_Hash_Correctly(){
        fail();
    }


}
