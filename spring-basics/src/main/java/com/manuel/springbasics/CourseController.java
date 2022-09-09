package com.manuel.springbasics;

import com.manuel.springbasics.model.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @GetMapping("/course")
    public List<Course> sendCourseBack(){

//        Course course = Course
//                .builder()
//                .id(1L)
//                .name("Emmanuel")
//                .author("Olah")
//                .build();

        return Arrays.asList(new Course(1L, "Emmanuel", "Olah"));
    }
}
