package com.manuel.springdatajpa.repository;

import com.manuel.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
public List<Student> findByFirstName(String firstName);
public List<Student> findByFirstNameContaining(String name);

//public List<Student> findByNonNull(String lastname);

public List<Student> findByGuardianName(String guardian);
public Student findByFirstNameAndLastName(String firstname, String lastname);

//JPAQuery //qeury is based on class and its attributes as against the attribute values in db table
@Query("select s from Student s where s.emailId=?1")
Student getStudentByEmailAddress(String emailId);
@Query("select s.firstName from Student s where  s.emailId = ?1")
String getStudentWhereFirstNameMatch(String firstname);

// Native sql queries
    @Query( value = "SELECT * FROM tbl_student s where s.email_address = ? 1",
            nativeQuery = true)
    String getStudentByEmailAddressNative();

    /* when I want to use SQL native query and with more than one parameter */
    @Query(value = "SELECT * FROM tbl_student s WHERE s.email = :emailId", nativeQuery = true)
    String getStudentByEmailAddressNativeParam(@Param("emailId") String email);

    /* updating a record */
    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
    int updateStudentNameByEmailId(String firstname, String emailId);

}
