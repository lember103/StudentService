package com.example.demo.Controller;

import com.example.demo.Model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentController {

    private StudentService service;

    @Autowired
    public StudentController(StudentService service){
        this.service = service;
    }

    @GetMapping(path = "{id}")
    public Student getStudent(@PathVariable int id){
        return service.getStudent(id);
    }

    @GetMapping(name = "{search}")
    public List<Student> studentList(@RequestParam Optional<String> search){
        if(search.isPresent()){
            return service.searchStudentByName(search.get());
        }
        return service.listStudents();
    }

    @PutMapping
    public void addStudent(@RequestBody Student student){
        service.addStudent(student);
    }

    @DeleteMapping(path= "{id}")
    public void deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
    }
}
