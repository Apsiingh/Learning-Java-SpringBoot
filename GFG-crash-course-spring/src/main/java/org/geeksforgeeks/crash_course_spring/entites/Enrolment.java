package org.geeksforgeeks.crash_course_spring.entites;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.geeksforgeeks.crash_course_spring.enums.EnrolmentStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "enrolment")
@NoArgsConstructor
@Getter
@Setter
public class Enrolment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "id" , nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id" , nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id" , nullable = false)
    private  Course course;

    @Column(name =  "enrolment_date" , nullable = false)
    private LocalDateTime enrolmentDate;

    @Column(name = "status" , nullable = false)
    private EnrolmentStatus status = EnrolmentStatus.ACTIVE;
}
