package com.example.demo.repo;

import com.example.demo.Model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class StudentRepo {

    private List<Student> studentRepo = new ArrayList<>();

    public void addStudent(Student newStudent) {
        for (Student student : studentRepo) {
            if (student.getId() == newStudent.getId()){
                throw new IllegalArgumentException("Id " + newStudent.getId() + " does already exist!");
            }
        }
        studentRepo.add(newStudent);
    }

    public Student getStudent(int id) {
        for (Student student : studentRepo) {
            if (student.getId() == id) return student;
        }
        throw new IllegalArgumentException("Student with id " + id + " not found!");
    }

    public List<Student> getStudentByName(String name) {
        List<Student> students = new ArrayList<>();
        for (Student student : studentRepo) {
            if (student.getName().equals(name)) {
                students.add(student);
            }
        }
        return students;
    }

    public List<Student> list() {
        return studentRepo;
    }

    public void deleteStudent(int id) {
        for (Student student : studentRepo) {
            if (student.getId() == id) {
                studentRepo.remove(student);
                break;
            }
        }
    }
}
