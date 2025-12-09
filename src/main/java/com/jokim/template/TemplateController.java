package com.jokim.template;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {


    @GetMapping("/template")
    public String template(Model model) {
        model.addAttribute("message", "thymeleaf");
        return "template";
    }
}
