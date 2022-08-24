package com.manuel.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(
            name = "course_generator",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private long courseId;
    private String courseTitle;
    private Integer credits;

    // getting a reference of bidirectional linked table. IF cascade already use,
    // USE: mappedBy and reference the column in the referenced table whose name match this.object name, like so

    @OneToOne(mappedBy = "course", optional = false)
    private CourseMaterial courseMaterial;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private Teacher teacher;

    /* this is where many-to-many relationship is implemented in the code */
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_course_map",
    joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "courseId"),
    inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "studentId")
    )
    private List<Student> students;

    public void addStudent(Student student){
        if (students == null){
            students = new ArrayList<>();
        }
        students.add(student);
    }

}
