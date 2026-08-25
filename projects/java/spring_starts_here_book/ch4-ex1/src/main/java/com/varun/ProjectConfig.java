package com.varun;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.varun.proxies" , "com.varun.repository" , "com.varun.services"})
public class ProjectConfig {
    
}
