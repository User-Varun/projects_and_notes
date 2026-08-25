package com.varun;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varun.Config.ProjectConfig;
import com.varun.Parrot.Parrot;;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
         
        
        // var p1 = context.getBean("parrot1" , Parrot.class);
        // var p2 = context.getBean("parrot2" , Parrot.class);
        // var p3 = context.getBean("parrot3" , Parrot.class);
        
        var p1 = context.getBean(Parrot.class);
        var p2 = context.getBean(Parrot.class);
        var p3 = context.getBean(Parrot.class);
        
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p1.getName());
        System.out.println(p2.getName());
        System.out.println(p3.getName());

        context.close();
    }
}