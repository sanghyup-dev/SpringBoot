package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

  public static void main(String[] args) {
    // 1. Launch a Spring Context

    var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

    // 2. Configure the things that we want Spring to manage - @Configuration
    //  HelloWorldConfiguration class has "name - @Bean"

    // 3. Retrieving Beans managed by Spring
    System.out.println(context.getBean("name"));

  }
}