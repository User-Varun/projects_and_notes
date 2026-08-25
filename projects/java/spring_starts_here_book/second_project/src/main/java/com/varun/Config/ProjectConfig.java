package com.varun.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;



@Configuration
@ComponentScan(basePackages = "com.varun")
public class ProjectConfig {
    
    // @Bean
    // Parrot parrot1(){
    //     var p = new Parrot();
    //     p.setName("koko");
    //     return p;
    // }

    // @Bean 
    // Parrot parrot2(){
    //     var p = new Parrot();
    //     p.setName("miki");
    //     return p;   

    // }

    // @Bean
    // Parrot parrot3(){
    //     var p = new Parrot();
    //     p.setName("chiki");
    //     return p;
    // }
}
