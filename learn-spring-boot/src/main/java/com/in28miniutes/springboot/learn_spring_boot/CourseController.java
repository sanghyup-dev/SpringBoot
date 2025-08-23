package com.in28miniutes.springboot.learn_spring_boot;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// /courses
// Course: id, name, author

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
      return Arrays.asList(
          new Course(1, "Learn AWS", "in28minutes"),
          new Course(2, "Learn DevOps", "in28minutes")
      );
    }
}
