package org.geeksforgeeks.crash_course_spring.repository;

import org.geeksforgeeks.crash_course_spring.entites.Course;
import org.geeksforgeeks.crash_course_spring.entites.Enrolment;
import org.geeksforgeeks.crash_course_spring.entites.Student;
import org.geeksforgeeks.crash_course_spring.enums.EnrolmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnrolmentRepository extends JpaRepository<Enrolment , Long> {

    // Just by looking the name of the function springBoot will automatically understand how to run this Query.
    long countByCourse(Course course);

    List<Enrolment> findByStudent(Student student);

    List<Enrolment> findByStudentAndStatus(Student student , EnrolmentStatus enrolmentStatus);

    // Write a function that take studentId as param and find all the enrollments for that student
    @Query("SELECT e FROM Enrolment e WHERE e.student.id = :studentId")
    List<Enrolment> findEnrolmentsByStudentId(@Param("studentId") Long studentId);
}
