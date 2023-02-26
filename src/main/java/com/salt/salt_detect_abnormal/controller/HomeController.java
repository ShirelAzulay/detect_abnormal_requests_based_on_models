package com.salt.salt_detect_abnormal.controller;

import com.salt.salt_detect_abnormal.repos.ModelDBRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    Logger logger = LoggerFactory.getLogger(HomeController.class);

    @GetMapping("/")
    public String index() {
        return "home/index";
    }

}
