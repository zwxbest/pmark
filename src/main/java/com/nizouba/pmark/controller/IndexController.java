package com.nizouba.pmark.controller;

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

    @GetMapping("/")
    public String index() {
        return "/index.html";
    }

    /**
     * @param pdf
     * @param bookmarks 书签
     * @param foramt    格式
     * @return
     */
    @PostMapping("/addPdfMarks")
    @ResponseBody
    public String addPdfMarks(MultipartFile pdf, String bookmarks, String foramt) {
        return null;
    }
}
