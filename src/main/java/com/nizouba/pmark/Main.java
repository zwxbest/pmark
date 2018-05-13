package com.nizouba.pmark;

import java.io.File;
import java.util.List;

/**
 * Created by zwxbest on 2018/3/1.
 * 3个参数，-page1  简写p1 页码中的第一页为pdf第几页。
 * -file  简写f ,pdf 文件的位置
 * -mark 简写mk 书签文本的位置
 * -format 简写ft，todo
 */
public class Main {

    private static BookmarksOperation bookmarksOperation;

    public static void main(String[] args) throws Exception {
        try {


            System.out.println("操作成功");

        } catch (NumberFormatException e) {
            System.out.println("页码必须为数字");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }



}
