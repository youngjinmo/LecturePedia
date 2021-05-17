package com.devandy.studypedia.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = {"/","/index","/home"})
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "/layout/about";
    }
}
