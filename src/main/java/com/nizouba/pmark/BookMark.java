package com.nizouba.pmark;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zwxbest on 2018/3/1.
 */

@Setter @Getter
public class BookMark implements Comparable{
    private String title;
    private int num=1;
    private BookMark parent;
    private Integer order;



    @Override
    public int compareTo(Object o) {
        if(o.getClass().equals(this.getClass()))
        {

        }
        return 0;
    }

}
