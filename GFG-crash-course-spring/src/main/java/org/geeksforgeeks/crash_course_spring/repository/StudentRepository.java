package org.geeksforgeeks.crash_course_spring.repository;

import org.geeksforgeeks.crash_course_spring.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student,Long> {

}
