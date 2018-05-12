package com.nizouba.pmark;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zwxbest on 2018/3/1.]
 * 书签操作类
 */
public class BookmarksOperation {

    PdfReader reader;

    public void editBookmarks(String src, String dest) throws DocumentException, IOException {

        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        List<HashMap<String, Object>> list = SimpleBookmark.getBookmark(reader);
        changeToXYZ(list);
        stamper.setOutlines(list);
        stamper.close();
        reader.close();
    }

    private void changeToXYZ(List<HashMap<String, Object>> list) {
        for (HashMap<String, Object> entry : list) {
            for (String key : entry.keySet()) {
                if ("Kids".equals(key)) {
                    Object o = entry.get(key);
                    changeToXYZ((List<HashMap<String, Object>>) o);
                } else if ("Page".equals(key)) {
                    String dest = (String) entry.get(key);
                    entry.put("Page", dest.replaceAll("\\b(Fit|FitV|FITB|FITBH|FITBV|FITH|FITR)\\b", "XYZ"));
                }
            }
        }
    }


    public void createBookmarks(List<BookMark> booksmarks, String src, String dest) throws Exception {
        Document document = new Document();
        reader = new PdfReader(src);
        PdfCopy copy = new PdfCopy(document, new FileOutputStream(dest));
        document.open();

        PdfOutline root = copy.getRootOutline();

        copy.addDocument(reader);
        PdfDestination destination = new PdfDestination(
                PdfDestination.XYZ, -1, -1, 0);

        PdfAction action;
        copy.freeReader(reader);
        Map<BookMark, PdfOutline> maps = new HashMap<>();
        PdfOutline outline=null;
        PdfOutline parent=root;
        for (BookMark bookMark : booksmarks) {
            action = PdfAction.gotoLocalPage(bookMark.getNum(), destination, copy);
            if(bookMark.getParent()!=null)
                parent=maps.get(bookMark.getParent());
            else
                parent=root;
            outline = new PdfOutline(parent, action, bookMark.getTitle(), false);
            maps.put(bookMark, outline);
        }
        copy.flush();
        copy.close();
        document.close();

    }

}




