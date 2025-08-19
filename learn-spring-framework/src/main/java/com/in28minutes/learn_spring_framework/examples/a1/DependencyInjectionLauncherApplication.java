package com.in28minutes.learn_spring_framework.examples.a1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learn_spring_framework.game")
public class DependencyInjectionLauncherApplication {

  public static void main(String[] args) {

    try (
        var context = new AnnotationConfigApplicationContext(
            DependencyInjectionLauncherApplication.class)
    ) {
      context.getBean(GamingConsole.class).up();
      context.getBean(GameRunner.class).run();
    }

  }
}