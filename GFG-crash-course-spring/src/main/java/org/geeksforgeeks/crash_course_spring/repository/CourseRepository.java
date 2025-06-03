package org.geeksforgeeks.crash_course_spring.repository;

import org.geeksforgeeks.crash_course_spring.entites.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends  JpaRepository <Course , Long>{
}
