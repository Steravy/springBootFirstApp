package com.springBoot.first.app;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {

    private final List<Student> students = new LinkedList<>();
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

    public Optional<Student> getStudent(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public Optional<Student> getByFirstAndLastName(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

}