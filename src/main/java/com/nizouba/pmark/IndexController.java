package com.nizouba.pmark;

import com.nizouba.pmark.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by zhangweixiao on 2018/5/12.
 */
@Controller
public class IndexController {

    @Autowired
    private BookmarkService bookmarkService;

    @GetMapping("/")
    public String index() {
        return "/index.html";
    }



    @PostMapping("/addPdfMarks")
    @ResponseBody
    public String addPdfMarks(Command command) {
        try {
            bookmarkService.addOrEditBookMarks(command);
            return "success";
        }
        catch (Exception e)
        {
            return e.getMessage();
        }

    }
}
