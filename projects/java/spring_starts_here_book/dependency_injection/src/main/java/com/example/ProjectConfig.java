package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.example")
public class ProjectConfig {

    // method 1 of wiring bean using the @bean

    @Bean
    public Parrot parrot() {
        Parrot p = new Parrot();
        p.setName("koko");
        return p;
    }

    // method 1
    // @Bean
    // public Person person() {
    //     Person p = new Person();
    //     p.setName("Ella");
    //     p.setParrot(parrot()); // this is the key point
    //     return p;
    // }

    // method 2 (providing parameter so springs injects the obj)
    // this is what known as dependency injection
    // @Bean
    // public Person person(Parrot parrot){
    //     Person p = new Person();

    //     p.setName("Ella");
    //     p.setParrot(parrot);

    //     return p;
    // }

    // method 3 is using @Autowired annotation (in the class that is adding obj --> see in Person.java)
}
