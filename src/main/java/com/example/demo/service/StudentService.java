package com.example.demo.service;

import com.example.demo.Model.Student;
import com.example.demo.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private StudentRepo studentRepo = new StudentRepo();

    @Autowired
    public StudentService(StudentRepo studentRepo){
        this.studentRepo = studentRepo;
    }

    public Student getStudent(int id){
        return studentRepo.getStudent(id);
    }

    public void addStudent(Student student){
        studentRepo.addStudent(student);
    }

    public List<Student> searchStudentByName(String name){
        return studentRepo.getStudentByName(name);
    }

    public List<Student> listStudents(){
        return studentRepo.list();
    }

    public void deleteStudent(int id){
        studentRepo.deleteStudent(id);
    }
}
