package com.springBoot.first.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAll() {

//        Student student = new Student("Stefan", "Vitoria");
//        student.setId(0);
//        student.setAge(20);
        return ResponseEntity.ok(studentService.getStudents());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable int id) {

        Optional<Student> student = studentService.getStudent(id);

       return student.isPresent() ? ResponseEntity.ok(student.get()) :
                new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);

//        if (student.isPresent()) {
//            return ResponseEntity.ok(student.get());
//        }
//
//        return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {

        return ResponseEntity.ok(studentService.create(student));
    }

//    public List<Student> getStudents
}