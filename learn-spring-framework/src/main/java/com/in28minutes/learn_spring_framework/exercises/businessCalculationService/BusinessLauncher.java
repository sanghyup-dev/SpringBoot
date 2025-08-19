package com.in28minutes.learn_spring_framework.exercises.businessCalculationService;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BusinessLauncher {

  public static void main(String[] args) {
    try (var context = new AnnotationConfigApplicationContext(BusinessLauncher.class)) {
      System.out.println(context.getBean(BusinessCalculationService.class).findMax());
    }
  }
}
