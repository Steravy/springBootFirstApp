package com.springBoot.first.app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new LinkedList<>();
    private int id = 0;

    public Student create(Student student) {
        id++;
        student.setId(id);
        this.students.add(student);
        return student;
    }
    public List<Student> getStudents() {
        return this.students;
    }

}