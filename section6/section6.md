# section 6

## H2 database

enabling H2 console: application.properties -> add `spring.h2.console.enable=true`
-> http://localhost:8080/h2-console
(the url in H2 console is always wrong. must check)

configuring a static URL for H2 : `spring.datasource.url=jdbc:h2:mem:testdb`

creating a tabel : add `schema.sql` file to `resources` folder

```SQL
-- schema.sql

create TABLE course
(
  id bigint not null,
  name VARCHAR(255) not null,
  author VARCHAR(255) not null,
  PRIMARY KEY (id)
);
```

## Spring JDBC

**JDBC**

-   Write a lot of SQL queries! (delete from todo where id=?)
-   And write a lot of Java code

**Spring JDBC**

-   Write a lot of SQL queries (delete from todo where id=?)
-   BUT lesser Java code

CommandLineRunner can be used to make a bean run at the start of a spring application

`JdbcTemplate.update` is used to execute sql  
`jdbcTemplate.update("delete from todo where id=?", id);`

`JdbcTemplate.query` or `JdbcTemplate.queryForObject` is used to get results from sql
`springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class),  ID);`

-   RowMapper: "adapter" that converts one DB row → one Java object
    -   BeanPropertyRowMapper: Auto-maps columns → JavaBean properties if names match

## JPA

Mapping Beans(@Entity) directly to database table  
=> use `@Id`, `@Column`(no need for column if names match)  
no need to worry about queries

```Java
@Repository
@Transactional
public class CourseJpaRepository
{
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course){
      entityManager.merge(course);
    }

    public Course findById(long id){
      return entityManager.find(Course.class, id);
    }

    public void deleteById(long id){

      Course course = entityManager.find(Course.class, id);
      entityManager.remove(course);
    }
}
```

to see sqls executed: `application.properties` -> add `spring.jpa.show-sql=true`

## Spring Data JPA

Makes JPA even more simple

`public interface CourseSpringDataJpaRepository extends JpaRepository<Entity, type of Id> {}`
-> this is all we need to do

can add methods to `findBy` by following naming convention
-> `List<Course> findByAuthor(String author);`

## Hibernate vs JPA

-   **JPA defines the specification. It is an API.**

    -   How do you define entities?
    -   How do you map attributes?
    -   Who manages the entities?

-   **Hibernate is one of the popular implementations of JPA**

-   **Using Hibernate directly would result in a lock-in to Hibernate**
    -   There are other JPA implementations (Toplink, for example)
