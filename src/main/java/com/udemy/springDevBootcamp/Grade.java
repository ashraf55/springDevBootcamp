package com.udemy.springDevBootcamp;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Grade {
    private String name;
    private String subject;
    private String score;
    private String id;

    public Grade() {
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    //    Static method to generate multiple Student data
//    2nd step: loading multiple data in grid view
//    public static List<Grade> generateSampleData() {
//        List<Grade> grades = new ArrayList<>();
//        grades.add(new Grade("A+", "Math", "Ashraful Karim"));
//        grades.add(new Grade("B-", "Science", "Ehsan Hoque"));
//        grades.add(new Grade("C+", "History", "Alvi Rahman"));
//        grades.add(new Grade("B-", "Art", "Shanto Pagla"));
//        grades.add(new Grade("A-", "Biology", "Shamim Khan"));
//        grades.add(new Grade("C-", "Music", "Ayesha Sultana"));
//        grades.add(new Grade("B-", "Physics", "Rifat Shahran"));
//        return grades;
//    }
}
