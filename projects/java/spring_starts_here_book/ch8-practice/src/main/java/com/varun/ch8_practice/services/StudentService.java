package com.varun.ch8_practice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.varun.ch8_practice.model.Student;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();
    
    public List<Student> getAllStudents(){
      return students;
    }

    public void addStudent(Student s){
        students.add(s);
    }
}
