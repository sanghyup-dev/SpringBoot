# Section 4

## Lazy Initalization

Default initialization for Spring Beans : Eager
Eager initialization is recommended:
- Errors in the configuration are discovered immediately at application startup
Configure beans to be lazily initialized using Lazy annotation:
- NOT recommended (AND) Not frequently used
Lazy annotation:
- Can be used almost everywhere @Component and @Bean are used
- Lazy-resolution proxy will be injected instead of actual dependency
-Can be used on Configuration (@Configuration) class:
 All @Bean methods within the @Configuration will be lazily initialized

## Comparing Lazy Initialization vs Eager Initialization

| Heading                                   | Lazy Initialization                                                                 | Eager Initialization                                       |
|-------------------------------------------|-------------------------------------------------------------------------------------|------------------------------------------------------------|
| **Initialization time**                   | Bean initialized when it is first made use of in the application                    | Bean initialized at startup of the application             |
| **Default**                               | NOT Default                                                                         | Default                                                    |
| **Code Snippet**                          | `@Lazy` OR `@Lazy(value=true)`                                                      | `@Lazy(value=false)` OR (Absence of `@Lazy`)               |
| **What happens if there are errors in initializing?** | Errors will result in runtime exceptions                                            | Errors will prevent application from starting up            |
| **Usage**                                 | Rarely used                                                                         | Very frequently used                                       |
| **Memory Consumption**                    | Less (until bean is initialized)                                                    | All beans are initialized at startup                       |
| **Recommended Scenario**                  | Beans very rarely used in your app                                                  | Most of your beans                                         |

## Spring Bean Scopes

- Singleton – One object instance per Spring IoC container  
- Prototype – Possibly many object instances per Spring IoC container  

### Web-aware Scopes

Scopes applicable only for a web-aware Spring ApplicationContext:

- Request – One object instance per single HTTP request  
- Session – One object instance per user HTTP session  
- Application – One object instance per web application runtime  
- Websocket – One object instance per WebSocket instance  

### Java Singleton (GOF) vs Spring Singleton

- Spring Singleton – One object instance per Spring IoC container  
- Java Singleton (GOF) – One object instance per JVM

### Prototype vs Singleton Bean Scope

| Heading                | Prototype                                                                 | Singleton                                                                 |
|-------------------------|---------------------------------------------------------------------------|---------------------------------------------------------------------------|
| Instances              | Possibly Many per Spring IOC Container                                    | One per Spring IOC Container                                              |
| Beans                  | New bean instance created every time the bean is referred to              | Same bean instance reused                                                 |
| Default                | NOT Default                                                               | Default                                                                   |
| Code Snippet           | `@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)`                  | `@Scope(value= ConfigurableBeanFactory.SCOPE_SINGLETON)` OR Default       |
| Usage                  | Rarely used                                                               | Very frequently used                                                      |
| Recommended Scenario   | Stateful beans                                                            | Stateless beans                                                           |

## `@PostConstruct` and `@PreDestroy`

- **`@PostConstruct`**  
  - Runs **after dependency injection** is done.  
  - Used to perform initialization logic, such as opening resources, validating configuration, or preparing data.  
  - Example: connecting to a database after the bean is created.  

- **`@PreDestroy`**  
  - Runs **before the bean is removed** from the Spring context.  
  - Used to perform cleanup, such as closing connections, releasing resources, or saving final state.  
  - Example: closing a file or shutting down a thread pool.  
  
## Evolution of Jakarta EE: vs J2EE vs Java EE

- Enterprise capabilities were **initially built into JDK**
- With time, they were separated out:
  - **J2EE** - Java 2 Platform Enterprise Edition
  - **Java EE** - Java Platform Enterprise Edition (Rebranding)
  - **Jakarta EE** (Oracle gave Java EE rights to the Eclipse Foundation)
    - **Important Specifications:**
      - Jakarta Server Pages (JSP)
      - Jakarta Standard Tag Library (JSTL)
      - Jakarta Enterprise Beans (EJB)
      - Jakarta RESTful Web Services (JAX-RS)
      - Jakarta Bean Validation
      - Jakarta Contexts and Dependency Injection (CDI)
      - Jakarta Persistence (JPA)
    - Supported by **Spring 6** and **Spring Boot 3**
      - That's why we use `jakarta.*` packages (instead of `javax.*`)
  
## Jakarta Contexts & Dependency Injection (CDI)

- Spring Framework V1 was released in 2004
- **CDI specification** introduced into Java EE 6 platform in December 2009
- Now called **Jakarta Contexts and Dependency Injection (CDI)**
- CDI is a **specification (interface)**
  - Spring Framework *implements* CDI
- **Important Inject API Annotations:**
  - `@Inject` (~ `@Autowired` in Spring)
  - `@Named` (~ `@Component` in Spring)
  - `@Qualifier`
  - `@Scope`
  - `@Singleton`

## XML configuration

- write instructions in an **XML file**
- Before annotations and Java-based configuration became common, this was the main way to configure Spring.

### Example

#### 1. Define a Bean in XML

```xml
<!-- beans.xml -->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <!-- Define a bean -->
    <bean id="myService" class="com.example.MyService"/>

    <!-- Bean with dependency injection -->
    <bean id="userController" class="com.example.UserController">
        <property name="myService" ref="myService"/>
    </bean>

</beans>
```

#### 2. Load the XML in Java

```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
            new ClassPathXmlApplicationContext("beans.xml");

        UserController controller = context.getBean("userController", UserController.class);
        controller.run();
    }
}
```

- `<bean>`: Defines a Spring-managed object.
- `id`: Unique name to refer to the bean.
- `class`: The fully qualified class name of the bean.
- `<property>`: Used for **Dependency Injection** (wiring beans together).
- `ApplicationContext`: Loads and manages all the beans defined in the XML.

## Annotations vs XML Configuration

| Heading              | Annotations                                                            | XML Configuration                      |
|-----------------------|------------------------------------------------------------------------|----------------------------------------|
| Ease of use          | Very Easy (defined close to source - class, method and/or variable)    | Cumbersome                             |
| Short and concise    | Yes                                                                    | No                                     |
| Clean POJOs          | No. POJOs are polluted with Spring Annotations                         | Yes. No change in Java code.           |
| Easy to Maintain     | Yes                                                                    | No                                     |
| Usage Frequency      | Almost all recent projects                                             | Rarely                                 |
| Recommendation       | Either of them is fine BUT be consistent                               | Do NOT mix both                        |
| Debugging difficulty | Hard                                                                   | Medium                                 |

## Spring Stereotype Annotations

- **@Component** - Generic annotation applicable for any class  
  - **Base** for all Spring Stereotype Annotations  
  - **Specializations of @Component:**
    - **@Service** - Indicates that an annotated class has business logic
    - **@Controller** - Indicates that an annotated class is a "Controller" (e.g., a web controller)  
      - Used to define controllers in your web applications and REST API
    - **@Repository** - Indicates that an annotated class is used to retrieve and/or manipulate data in a database  

**RECOMMENDATION**: Use the most specific annotation possible  

### Why?

- By using a specific annotation, you are giving more information to the framework about your intentions.  
- You can use AOP at a later point to add additional behavior  
  - **Example**: For `@Repository`, Spring automatically wires in JDBC Exception translation features
