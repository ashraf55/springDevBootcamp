package com.udemy.springDevBootcamp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradeController {

//    creating array list to take input from form and show in grid
    List<Grade> studentGrades = new ArrayList<>();

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id){
//        Grade grade;
//        if(getGradeIndex(name) == -1000){
//            grade = new Grade();
//        } else {
//            grade = studentGrades.get(getGradeIndex(name));
//        }
        model.addAttribute("grade", getGradeIndex(id) == -1000 ? new Grade() : studentGrades.get(getGradeIndex(id)));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade){
        int index = getGradeIndex(grade.getId());
        if(index == -1000){
            studentGrades.add(grade);
        }else{
            studentGrades.set(index, grade);
        }
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

    public Integer getGradeIndex(String id){
        for(int i=0; i < studentGrades.size(); i++){
            if(studentGrades.get(i).getId().equals(id))
                return i;
        }
        return -1000;
    }
}
