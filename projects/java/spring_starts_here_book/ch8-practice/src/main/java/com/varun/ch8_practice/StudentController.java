package com.varun.ch8_practice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varun.ch8_practice.model.Student;
import com.varun.ch8_practice.services.StudentService;

@Controller
public class StudentController {
    
   StudentService ss;

   public StudentController(StudentService studentService){
    this.ss = studentService;
   }

   @GetMapping("/students")
   public String getAllStudents( Model m){

    var students  = ss.getAllStudents();
    
    m.addAttribute("students" , students );

    return "students.html";
   }

   @PostMapping("/students")
   public String addStudent(@RequestParam String name , @RequestParam double marks){

    Student s = new Student();

    s.setName(name);
    s.setMarks(marks);

    ss.addStudent(s);

    return "students.html";

   }
}
