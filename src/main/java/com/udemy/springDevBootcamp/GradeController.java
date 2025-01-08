package com.udemy.springDevBootcamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GradeController {

    @GetMapping("/grades")
    public String getGrades(Model model){
//        Grade grade = new Grade("C-", "English", "Harry");
//        model.addAttribute("grade", grade);
//        return "grades";

        List<Grade> grades = Grade.generateSampleData();
        model.addAttribute("grades", grades);
        return "grades";
    }

    @GetMapping("/")
    public String gradeForm(Model model){
        model.addAttribute("grade", new Grade("C-", "English", "Harry"));
        return "form";
    }
}
