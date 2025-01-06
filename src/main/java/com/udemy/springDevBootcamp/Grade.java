package com.udemy.springDevBootcamp;

import java.util.ArrayList;
import java.util.List;

public class Grade {
    private String name;
    private String subject;
    private String score;

    public Grade(String score, String subject, String name) {
        this.score = score;
        this.subject = subject;
        this.name = name;
    }
//
//    public Grade() {
//    }

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

    // Static method to generate multiple Student data
    public static List<Grade> generateSampleData() {
        List<Grade> grades = new ArrayList<>();
        grades.add(new Grade("A+", "Math", "Ashraful Karim"));
        grades.add(new Grade("B-", "Science", "Ehsan Hoque"));
        grades.add(new Grade("C+", "History", "Alvi Rahman"));
        grades.add(new Grade("B-", "Art", "Shanto Pagla"));
        grades.add(new Grade("A-", "Music", "Shamim Khan"));
        return grades;
    }
}
