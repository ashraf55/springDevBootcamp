package com.udemy.springDevBootcamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilityMethod {

    @GetMapping("/name")
    public String getMethodName(Model model){
        model.addAttribute("name","Kayser Ahmed");
        return "view";
    }

}
