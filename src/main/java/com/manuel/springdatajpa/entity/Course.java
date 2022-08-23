package com.manuel.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;
}
