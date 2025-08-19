# Section 3

## Getting Spring Framework to Create and Manage Your Java Objects

"@Component" annotation on a class will make spring manage the class as a bean
"@ComponentScan("packagenamethathascomponents")" will automatically find components and make instances of the class with @component

## Spring Component Primary & Qualifier

"@primary" annotation or "@qualifier" annotation can be used to resolve multiple candidates

### Which one to use?

- @Primary – A bean should be given preference when multiple candidates are qualified
- @Qualifier – A specific bean should be auto-wired (name of the bean can be used as qualifier)
- ALWAYS think from the perspective of the class using the SortingAlgorithm:
  1. Just @Autowired: Give me (preferred) SortingAlgorithm
  2. @Autowired + @Qualifier: I only want to use specific SortingAlgorithm – RadixSort

(REMEMBER) @Qualifier has higher priority than @Primary

## Dependency Injection Types

Constructor-based: Dependencies are set by creating the Bean using its Constructors  
  \- No need for @Autowired annotation  
  \- RECOMMENDED - all dependancies are set in one method(when object is created)

Setter-based: Dependencies are set by calling setter methods on your beans

Field: No setter or constructor. Dependency is injected using reflection.

## Important Terminology

@Component (..): An instance of class will be managed by Spring framework

Dependency: GameRunner needs GameingConsole implementation

- gameingConsole impl is a dependency of GameRunner

Component Scan: How does Spring Framework find component classes

- scans packages given as parameter or the current file as default
- scannes all the subpackages too

Dependency Injection: Identify beans, their dependencies and wire them together(provides IOC - Inversion of Control)

- Spring Beans: An object managed by Spring Framework

- IoC container: Manages the lifecycle of beans and dependencies  
  - Types: `ApplicationContext` (complex), `BeanFactory` (simpler features - rarely used)

- Autowiring: Process of wiring in dependencies for a Spring Bean

## @Component vs @Bean

| Heading           | @Component                                               | @Bean                                                                                 |
|-------------------|----------------------------------------------------------|---------------------------------------------------------------------------------------|
| Where?            | Can be used on any Java class                             | Typically used on methods in Spring Configuration classes                            |
| Ease of use        | Very easy. Just add an annotation                        | You write all the code.                                                               |
| Autowiring        | Yes - Field, Setter or Constructor Injection              | Yes - method call or method parameters                                                |
| Who creates beans?| Spring Framework                                          | You write bean creation code                                                          |
| Recommended For   | Instantiating Beans for Your Own Application<br>Code: @Component | 1: Custom Business Logic<br>2: Instantiating Beans for 3rd-party libraries: @Bean     |


## Why do we have Dependencies?

Real World applications are much more complex:

- Multiple Layers (Web, Business, Data etc)
  - Each layer is dependent on the layer below it
    - Example: Business Layer class talks to a Data Layer class
      - Data Layer class is a dependency of Business Layer class
      - There are thousands of such dependencies in every application
- Using Spring Framework:
  - Instead of focusing on objects, their dependencies and wiring => can focus on the business logic
  - Spring Framework manages the lifecycle of objects:
    - Mark components using annotations: @Component (and others..)
    - Mark dependencies using @Autowired
