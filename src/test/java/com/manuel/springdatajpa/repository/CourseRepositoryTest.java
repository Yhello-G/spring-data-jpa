package com.manuel.springdatajpa.repository;

import com.manuel.springdatajpa.entity.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private  CourseRepository cr;
    @BeforeEach
    void setUp() {
    }

    @Test
    public void printAllAvailableCourse(){
        List<Course> courses = cr.findAll();
        System.out.println("List of Courses:"+ courses);
    }

}