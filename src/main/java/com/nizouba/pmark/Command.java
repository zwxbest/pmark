package com.nizouba.pmark;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zwxbest on 2018/5/10.
 */
@Getter @Setter
public class Command {

    private Integer offset = 0;
    private String pdf = null;
    private String bookmarks = null;
    private String type = null;
    private String format;
}

