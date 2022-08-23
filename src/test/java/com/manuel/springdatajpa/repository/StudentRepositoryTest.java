package com.manuel.springdatajpa.repository;

import com.manuel.springdatajpa.entity.Guardian;
import com.manuel.springdatajpa.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @BeforeEach
    void setUp() {
    }

    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("email@gmail.com")
                .firstName("Emmanuel")
                .lastName("Ola")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> students = studentRepository.findAll();
        System.out.println("Students: ="+ students );
    }

    @Test
    public  void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Asiriuwa").email("asiri@gmail.com")
                .mobile("09012345678").build();


        Student student = Student.builder()
                .firstName("Emmanuel")
                .lastName("Ola")
                .emailId("email2@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Emmanuel");
        System.out.println("Student Name:"+ students);
    }

    @Test
    public void findByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("Em");
        System.out.println("Matched Student: "+ students);
    }

    @Test
    public void findByLast(){
//        List<Student> students = studentRepository.findByNonNull("la");
//        System.out.println("Student With Matching Lastname: "+ students);
    }

    @Test
    public void findStudentByGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("asiriuwa");
        System.out.println("By Guardian Name: "+ students);
    }
}