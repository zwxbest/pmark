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
//
//    private static BookmarksOperation bookmarksOperation;
//
//    public static void main(String[] args) throws Exception {
//        try {
//
//
//            if (args == null || args.length <= 1) {
//                usage();
//
//            }
//            Command cmd = new Command();
//            for (int i = 0; i < args.length; i++) {
//                cmd.setCommand(args[i], i + 1 == args.length ? null : args[i + 1]);
//            }
//            if (cmd.isAdd() == null) {
//                throw new Exception("请选择创建或者编辑书签");
//            }
//            if (cmd.getOffset() <= 0) {
//                throw new Exception("page1不为空，且大于0");
//            }
//            if (cmd.getFilePath() == null || !new File(cmd.getFilePath()).exists()) {
//                throw new Exception("请设置pdf路径或者路径无效,路径中如果包含空格请加引号");
//            }
//            if (cmd.getBookmarkPath() == null || !new File(cmd.getBookmarkPath()).exists()) {
//                throw new Exception("请设置书签路径或者路径无效,路径中如果包含空格请加引号");
//            }
//            bookmarksOperation = new BookmarksOperation();
//            String destPath = getDestPath(cmd.getFilePath(), cmd);
//            if (cmd.isAdd()) {
//                List<BookMark> bookMarks = BookMarkInput.read(cmd.getBookmarkPath(), cmd.getOffset(),cmd.getFormat());
//                bookmarksOperation.createBookmarks(bookMarks, cmd.getFilePath(), destPath);
//            } else {
//                EditBookMarkToXYZ(cmd.getFilePath(), destPath);
//            }
//            System.out.println("操作成功");
//
//        } catch (NumberFormatException e) {
//            System.out.println("页码必须为数字");
//            usage();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            usage();
//        }
//
//
//    }
//
//    static String getDestPath(String src, Command cmd) {
//        File file = new File(src);
//        String fileName = file.getPath();
//        String destPath =  fileName.replaceAll("\\.pdf", "");
//        if (cmd.isAdd()) {
//            destPath += "-带书签";
//        }
//        File destFile;
//        int suffixNo = 1;
//        while (true) {
//            destPath+=".pdf";
//            destFile = new File(destPath );
//            if (!destFile.exists()) {
//                break;
//            }
//            destPath = destPath + "-" + suffixNo + ".pdf";
//        }
//        return destPath;
//    }
//
//    static void EditBookMarkToXYZ(String src, String dest) throws Exception {
//        bookmarksOperation.editBookmarks(src, dest);
//    }
//
//    static void usage() {
//        System.err.println("PDF书签生成编辑工具，使用iText开发");
//        System.err.println("复制当当或者亚马逊或者京东或者豆瓣的书签内容到txt中，即可为pdf生成书签");
//        System.err.println("也可编辑全部书签的页面大小为自定义，即书签跳转时不会重新缩放页面");
//        System.err.println("用法：");
//        System.err.println("jar pmark");
//        System.err.println("-add或-a：添加书签");
//        System.err.println("-edit或-e：编辑书签");
//        System.err.println("-offset或-of：书籍页码第1页为pdf第几页");
//        System.err.println("-file或者-f：pdf路径");
//        System.err.println("-mark或者-mk：txt书签路径");
//        System.err.println("-format或者-f：书签格式路径，根据格式进行解析");
//        System.err.println("提供占位符：{no}-数字序号，{zh_no}-中文数字序号,{content}- 内容,{page}-页码,不需要指定空格，每行代表一个层级，制作折叠书签");
//        System.err.println("非书签标题，例如");
//        System.err.println("例如：1-1 传播过度的社会　/9，应该定义为{no}-{no}{content}/{page}而不是{no}-{no}{content}{page}");
//        System.err.println("第{no}章{content}- 第1章　 到底何为定位");
//        System.err.println("{no}-{no}{content}/{page}--  1-1 传播过度的社会　/9");
//        System.exit(-1);
//    }

}
