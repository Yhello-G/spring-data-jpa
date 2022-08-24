package com.manuel.springdatajpa.repository;

import com.manuel.springdatajpa.entity.Course;
import com.manuel.springdatajpa.entity.CourseMaterial;
import com.manuel.springdatajpa.entity.Student;
import com.manuel.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private  CourseRepository cr;
    @Autowired
    private CourseMaterialRepository cmr;
    @BeforeEach
    void setUp() {
    }

    @Test
    public void printAllAvailableCourse(){
        List<Course> courses = cr.findAll();
        System.out.println("List of Courses:"+ courses);
    }

    @Test
    public void saveCourseAlongWithTeacher(){
//        CourseMaterial cm = CourseMaterial.builder()
//                .courseUrl("educative.ng").build();
//
//
//        Course java =  Course.builder()
//                .courseTitle("Master to Java II")
//                .credits(10)
//                .courseMaterial(cm)
//  //              .teacher(teacher)
//                .build();
//        cm.setCourse(java);
//        cmr.save(cm);
//        java.setCourseMaterial(cm);
//
//         Teacher teacher = Teacher.builder()
//                 .firstName("Mackson")
//                 .lastName("Angelo")
//                 .build();
//            java.setTeacher(teacher);
//            cr.save(java);

    }

    @Test
    public void findAllPagination(){
        Pageable ff = PageRequest.of(1,2);
        Pageable first3Page = PageRequest.of(0, 3);
      List<Course> courses =   cr.findAll(first3Page).getContent();
        System.out.println("Pages :"+ courses );
     Long totalElements = cr.findAll(first3Page).getTotalElements();
    }

    @Test
    public void findAllWithSorting(){
        Pageable sortByTitle = PageRequest.of(0, 3, Sort.by("course_title"));
        Pageable sortByCredits = PageRequest.of(0, 2, Sort.by("credits").descending());
        Pageable creditAndTitle = PageRequest.of(0, 2, Sort.by("course_title")
                .and(Sort.by("credits")));

        List<Course> courses = cr.findAll(sortByTitle).getContent();

        System.out.println("Sorted :"+ courses);
    }

    @Test
    public void printFindByTitleContaining(){
//        Pageable page1Of10 = PageRequest.of(0, 10);
//        List<Course> courses = cr.findByTitleContaining("D", page1Of10).getContent();
//        System.out.println("Courses:"+ courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher(){

        Teacher teacher = Teacher.builder().firstName("Ikwisa")
                .lastName("Poju").build();
        Course course = Course.builder().courseTitle("Mathematics")
                .credits(7)
                .teacher(teacher)
                .build();
        Student student = Student.builder().firstName("Ayomide")
                .lastName("Kolawole").emailId("ay@gmail.com").build();
        course.addStudent(student);

        cr.save(course);
    }

}