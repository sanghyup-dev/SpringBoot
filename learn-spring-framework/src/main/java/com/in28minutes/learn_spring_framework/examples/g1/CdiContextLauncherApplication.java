package com.in28minutes.learn_spring_framework.examples.g1;

import java.util.Arrays;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

class BusinessService{
  private
}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

  public static void main(String[] args) {

    try (
        var context = new AnnotationConfigApplicationContext(
            CdiContextLauncherApplication.class)
    ) {
      Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

  }
}