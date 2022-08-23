package com.manuel.springdatajpa.repository;

import com.manuel.springdatajpa.entity.Course;
import com.manuel.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository cmr;

    @BeforeEach
    void setUp() {
    }

    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .courseTitle("Programming")
                .credits(5)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .courseUrl("scholardemy.com")
                .course(course)
                .build();

        cmr.save(courseMaterial);
    }

    @Test
    public void printAllMaterials(){
        List<CourseMaterial> courseMaterials = cmr.findAll();
        System.out.println("CourseMaterials:"+ courseMaterials);
    }
}