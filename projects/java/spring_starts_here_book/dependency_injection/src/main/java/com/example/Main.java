package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot parrot = context.getBean(Parrot.class);
        Person person = context.getBean(Person.class);

        System.out.println(person.getName());
        System.out.println(parrot.getName());
        System.out.println(person.getParrot());
    }
}