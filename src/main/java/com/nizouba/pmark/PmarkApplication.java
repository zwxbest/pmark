package com.nizouba.pmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
public class PmarkApplication {



    public static void main(String[] args) {
        SpringApplication.run(PmarkApplication.class, args);
    }
}
