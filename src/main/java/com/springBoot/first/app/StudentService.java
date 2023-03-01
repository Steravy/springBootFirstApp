package com.springBoot.first.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class StudentService {

    private List<Student> students = new LinkedList<>();
    private int id = 0;

    private List<Student> getStudents() {
        return this.students;
    }

}