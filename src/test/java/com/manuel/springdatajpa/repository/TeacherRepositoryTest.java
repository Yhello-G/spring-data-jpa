package com.manuel.springdatajpa.repository;

import com.manuel.springdatajpa.entity.Course;
import com.manuel.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository tRepo;
    @BeforeEach
    void setUp() {
    }

    @Test
    public void saveTeacher(){
        Course gns = Course.builder()
                .courseTitle("English")
                .credits(3)
                .build();
        Course sysEngr = Course.builder()
                .courseTitle("System Engineering")
                .credits(5)
                .build();

        List<Course> courses = new ArrayList<>();
        courses.add(gns);
        courses.add(sysEngr);

        Teacher teacher = Teacher.builder()
                .firstName("Emmanuel")
                .lastName("Olah")
                //.courses(courses)
                .build();
        tRepo.save(teacher);
    }
}