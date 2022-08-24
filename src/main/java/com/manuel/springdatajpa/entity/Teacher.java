package com.manuel.springdatajpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_sequence", sequenceName = "teacher_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_sequence")

    private Long teacherId;
    private String firstName;
    private String lastName;

//    @OneToMany( cascade = CascadeType.ALL)
//    // JoinColumn defines a column in the Course table that reference back to teacher
//    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
//    private List<Course> courses;

    /* following best practice it is preferred that ManyToOne relationship is favoured */
}
