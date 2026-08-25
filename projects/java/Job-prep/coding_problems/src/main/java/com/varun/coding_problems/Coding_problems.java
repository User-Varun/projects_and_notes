/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.varun.coding_problems;

/**
 *
 * @author Varun
 */

class Student{
    String name;
    double age;
    double percentage;
    char grade;
    
    Student(String name, double age, double percentage, char grade){
        this.name = name;
        this.age = age;
        this.percentage =percentage;
        this.grade = grade;
    }
    
    @Override
    public String toString(){
      return "Name: " + name + ", Age: " + age + 
               ", Percentage: " + percentage + ", Grade: " + grade;
    }
}

public class Coding_problems {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Student s1 = new Student("varun" , 21 , 69.7 , 'A');
        
        // name, age , percentage , grade
       
        
        System.out.println(s1);
        
        
        
    }
}

