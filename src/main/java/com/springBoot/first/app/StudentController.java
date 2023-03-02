package com.springBoot.first.app;

import jakarta.websocket.server.PathParam;
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

    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<?> getByfirstOrLastName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {

        Optional<Student> student = studentService.getByFirstAndLastName(firstName, lastName);

        return student.isPresent() ? ResponseEntity.ok(student.get()) :
                new ResponseEntity<>(String.format("Student not found with first name: %s and last name: %s",
                        firstName, lastName), HttpStatus.NOT_FOUND);

    }

    //using query
    @GetMapping("/search")
    public ResponseEntity<?> getByFirstAndLastNameParams(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {
        System.out.println(firstName);
        System.out.println("____________________________________");
        System.out.println(lastName);

        Optional<Student> student = studentService.getByFirstAndLastName(firstName, lastName);

        if (student.isPresent()) {

            return ResponseEntity.ok(student.get());
        }
        return new ResponseEntity<>(String.format("Student not found with first name: %s and last name: %s",
                firstName, lastName), HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {

        return ResponseEntity.ok(studentService.create(student));
    }

}

//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