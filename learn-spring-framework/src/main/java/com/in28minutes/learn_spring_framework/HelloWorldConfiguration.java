package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {
  // Spring beans: things that are managed by Spring

  @Bean // method will produce a bean
  public String name() {
    return "Ranga";
  }

}
