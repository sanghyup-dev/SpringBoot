# section5

## Before Spring Boot

Dependency management(pom.xml): manage frameworks and versions  
web.xml
Spring Configurations
NFRs : Non Functional Requirements

## Most Important Goal of Spring Boot

helps build PRODUCTION READY apps QUICKLY

- QUICK
  - Spring Initializr
  - Spring Boot Starter Projects
  - Spring Boot Auto Configuration
  - Spring Boot DevTools
- PRODUCTION READY
  - Logging
  - Different Configuration for Different Environments
    - Profiles, ConfigurationProperties
  - Monitoring (Spring Boot Actuator)

## Spring Boot Starter Projects

Starters: Convenient dependency descriptors for different features

- Web Application & REST API - Spring Boot Starter Web (spring-webmvc, spring-web, spring-boot-starter-tomcat, spring-boot-starter-json)
- Unit Tests - Spring Boot Starter Test
- Talk to database using JPA - Spring Boot Starter Data JPA
- Talk to database using JDBC - Spring Boot Starter JDBC
- Secure your web application or REST API - Spring Boot Starter Security

## Spring Boot Auto Configuration

A typical Spring app needs a lot of configuration

Simplifying: Auto Configuration

- Decided based on:
  - Which frameworks are in the Class Path?
  - What is the existing configuration (Annotations etc)?

Example: Spring Boot Starter Web

- Dispatcher Servlet (DispatcherServletAutoConfiguration)
- Embedded Servlet Container - Tomcat is the default (EmbeddedWebServerFactoryCustomizerAutoConfiguration)
- Default Error Pages (ErrorMvcAutoConfiguration)
- Bean<->JSON (JacksonHttpMessageConvertersConfiguration)

## Spring Boot DevTools

add `spring-boot-devtools` to pom.xml dependency  

Increase developer productivity  
Automatic restart of server for code change  

Remember: For pom.xml dependency changes, you will need to restart server manually

## Spring Boot PRODUCTION-READY