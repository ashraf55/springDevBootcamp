package com.udemy.springDevBootcamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradeController {

//    creating array list to take input from form and show in grid
    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/")
    public String gradeForm(Model model){
        model.addAttribute("grade",
                new Grade());
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade){
        System.out.println(grade);
        studentGrades.add(grade);
        return "redirect:/grades";
    }

    @GetMapping("/grades")
    public String getGrades(Model model){
//        1st step: singly loading the grid view
//        Grade grade = new Grade("C-", "English", "Harry");
//        model.addAttribute("grade", grade);
//        return "grades";

//        2nd step: loading multiple data in grid view
//        List<Grade> grades = Grade.generateSampleData();
//        model.addAttribute("grades", grades);
//        return "grades";

        model.addAttribute("grades", studentGrades);
        return "grades";
    }
}
