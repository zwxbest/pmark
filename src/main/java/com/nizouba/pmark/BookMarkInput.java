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


    static List<String> getFormarts(String formatFile) throws IOException {
        List<String> formats = new ArrayList<>();
        BufferedReader fs = new BufferedReader(new FileReader(formatFile));
        String format = fs.readLine();
        while (format != null) {
            String separation = "[　\\s]+";//注意半角空格
            format = format.replaceAll("^", "(");
            format = format.replaceAll("\\{content\\}", separation + "(.*)" + separation);
            format = format.replaceAll("\\{page\\}", separation + "([0-9]+)" + separation);
            Matcher matcher = Pattern.compile("(\\{no\\}.*\\{no\\}})").matcher(format);//去掉空格符合换行符
            format = matcher.replaceAll("(" + matcher.group(1) + ")");
            format = format.replaceAll("\\{no\\}", separation + "([0-9]+)" + separation);
            formats.add(format);
        }
        return formats;
    }

    public static List<BookMark> read(String file, int offset, String formatFile) throws Exception {

        List<String> formats = getFormarts(formatFile);
        String[] bookmarks = file.split("\\\\r\\\\n");


        List<BookMark> bookMarks = new ArrayList<>();
        Matcher m;
        Pattern p;
        for(String bookmark:bookmarks)
        {
            BookMark bookMark = new BookMark();
            if (!bookmark.trim().equals("")) {
                for (int i = formats.size() - 1; i >= 0; i--) {
                    p = Pattern.compile(formats.get(i));
                    m = p.matcher(bookmark);
                    bookMark.setParent(null);
                    if (m.find()) {
                        bookMark.setTitle(m.group(1));
                        bookMark.setOrder(m.group(2));
                        if (m.groupCount() == 4) {
                            bookMark.setNum(Integer.valueOf(m.group(3)) + offset);
                        }
                        for (int j = bookMarks.size() - 1; j >= 0; j--) {
                            if (bookMark.getOrder().contains(bookMarks.get(i).getOrder() + ".")) {
                                bookMark.setParent(bookMarks.get(i));
                                break;
                            }
                        }
                    }
                }

            }
            bookMarks.add(bookMark);
        }
        return bookMarks;
    }
}
