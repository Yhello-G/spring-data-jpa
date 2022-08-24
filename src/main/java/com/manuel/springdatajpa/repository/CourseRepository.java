package com.manuel.springdatajpa.repository;

import com.manuel.springdatajpa.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

Page<Course> findByCourseTitleContaining(String title, Pageable pageable);

}
