package com.nizouba.pmark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zwxbest on 2018/3/1.
 */
public class BookMarkInput {


    static List<String> getFormarts(String formats) throws IOException {
       String[] formatArray = formats.split("\\r\\\n");
       List<String> formatList=new ArrayList<>();
       for(String format:formatArray)
       {
           String separation = "[　\\\\s]*";//注意半角空格
           String separation2 = "[　\\\\s]*";//注意半角空格
           format= format.replaceAll("\\.","\\\\.");
           format = format.replaceAll("^", "(");
           format = format.replaceAll("\\{content\\}", separation + ".*?" + separation2+")");
           format = format.replaceAll("\\{page\\}", separation + "([0-9]+)" + separation);
           format = format.replaceAll("\\{no\\}", separation + "[0-9]+" + separation);
//           Matcher matcher = Pattern.compile("(\\{no\\}.*\\{no\\})").matcher(format);//去掉空格符合换行符
//           if(matcher.find())
//           {
//               format = matcher.replaceAll("(" + matcher.group(1) + ")");
//           }
           format = format.replaceAll("\\{no\\}", separation + "([0-9]+)" + separation);
           formatList.add(format);
       }
       return formatList;

    }

    public static List<BookMark> read(String file, Integer offset, String formatFile) throws Exception {

        List<String> formats = getFormarts(formatFile);
        String[] bookmarks = file.split("\\r\\n");

        List<BookMark> bookMarks = new ArrayList<>();
        Matcher m;
        Pattern p;
        for(String bookmark:bookmarks)
        {
            BookMark bookMark = new BookMark();
            boolean find=false;
            if (!bookmark.trim().equals("")) {
                for (int i = formats.size() - 1; i >= 0; i--) {
                    p = Pattern.compile(formats.get(i));
                    m = p.matcher(bookmark);
                    bookMark.setParent(null);
                    if (m.find()) {
                        find=true;
                        bookMark.setTitle(m.group(1));
                        bookMark.setOrder(i+1);
                        if (m.groupCount() == 2) {
                            bookMark.setNum(Integer.valueOf(m.group(2)) + offset);
                        }
                        for (int j = bookMarks.size() - 1; j >= 0; j--) {
                            if (bookMarks.get(j).getOrder()!=null && bookMark.getOrder()==bookMarks.get(j).getOrder()+1) {
                                bookMark.setParent(bookMarks.get(j));
                                break;
                            }
                        }
                        break;
                    }
                }
                if(find==false)
                {
                    bookMark.setTitle(bookmark.trim());
                }
                bookMarks.add(bookMark);
            }

        }
        return bookMarks;
    }
}
