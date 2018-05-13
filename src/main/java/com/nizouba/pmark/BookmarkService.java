package com.nizouba.pmark;

import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * Created by zhangweixiao on 2018/5/13.
 */
@Service
public class BookmarkService {

    BookmarksOperation bookmarksOperation;

    public void addOrEditBookMarks(Command cmd) throws Exception {
        bookmarksOperation = new BookmarksOperation();
        String destPath = getDestPath(cmd.getPdf(), cmd);
        if (cmd.getType().equals("add")) {
            List<BookMark> bookMarks =BookMarkInput.read(cmd.getBookmarks(), cmd.getOffset(), cmd.getFormat());
            bookmarksOperation.createBookmarks(bookMarks, cmd.getPdf(), destPath);
        } else {
            EditBookMarkToXYZ(cmd.getPdf(), destPath);
        }
    }

    String getDestPath(String src, Command cmd) {
        File file = new File(src);
        String fileName = file.getPath();
        String destPath = fileName.replaceAll("\\.pdf", "");
        if (cmd.getType().equals("add")) {
            destPath += "-带书签";
        }
        File destFile;
        int suffixNo = 1;
        while (true) {
            destPath += ".pdf";
            destFile = new File(destPath);
            if (!destFile.exists()) {
                break;
            }
            destPath = destPath.replaceAll("\\.pdf", "") + "-" + suffixNo;
        }
        return destPath;
    }

    void EditBookMarkToXYZ(String src, String dest) throws Exception {
        bookmarksOperation.editBookmarks(src, dest);
    }
}
