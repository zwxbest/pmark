package com.nizouba.pmark;

/**
 * Created by zwxbest on 2018/5/10.
 */
public class Command {

    //实际的第1页是pdf那一页
    public static final String COMMAND_OFFSET = "offset";
    public static final String COMMAND_OFFSET_SHORT = "os";
    //pdf文件名
    public static final String COMMAND_FILE = "file";
    public static final String COMMAND_FILE_SHORT = "f";
    //书签的txt文本名
    public static final String COMMAND_MARK = "mark";
    public static final String COMMAND_MARK_SHORT = "mk";

    //增加书签
    public static final String COMMAND_ADD = "add";
    public static final String COMMAND_ADD_SHORT = "a";

    //编辑书签缩放
    public static final String COMMAND_EDIT = "edit";
    public static final String COMMAND_EDIT_SHORT = "e";

    //格式 todo：
    public static final String COMMAND_FORMAT = "format";
    public static final String COMMAND_FORMAT_SHORT = "ft";


    private int offset = 0;
    private String filePath = null;
    private String bookmarkPath = null;
    private Boolean isAdd = null;
    private String format;

    public void setCommand(String command, String paramater) {
        command = command.replaceFirst("-", "");
        switch (command) {
            case COMMAND_OFFSET:
            case COMMAND_OFFSET_SHORT:
                this.setOffset(Integer.valueOf(paramater));
                break;
            case COMMAND_FILE:
            case COMMAND_FILE_SHORT:
                this.setFilePath(paramater);
                break;
            case COMMAND_MARK:
            case COMMAND_MARK_SHORT:
                this.setBookmarkPath(paramater);
                break;
            case COMMAND_ADD:
            case COMMAND_ADD_SHORT:
                this.setAdd(true);
                break;
            case COMMAND_EDIT:
            case COMMAND_EDIT_SHORT:
                this.setAdd(false);
                break;
            case COMMAND_FORMAT:
            case COMMAND_FORMAT_SHORT:
                this.format = paramater;
                break;
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getBookmarkPath() {
        return bookmarkPath;
    }

    public void setBookmarkPath(String bookmarkPath) {
        this.bookmarkPath = bookmarkPath;
    }

    public Boolean isAdd() {
        return isAdd;
    }

    public void setAdd(Boolean add) {
        isAdd = add;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
