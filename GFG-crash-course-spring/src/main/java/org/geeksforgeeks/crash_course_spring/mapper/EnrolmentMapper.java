package org.geeksforgeeks.crash_course_spring.mapper;

import org.geeksforgeeks.crash_course_spring.dto.EnrolmentDto;
import org.geeksforgeeks.crash_course_spring.entites.Course;
import org.geeksforgeeks.crash_course_spring.entites.Enrolment;
import org.geeksforgeeks.crash_course_spring.entites.Student;
import org.geeksforgeeks.crash_course_spring.exceptions.NotFoundException;
import org.geeksforgeeks.crash_course_spring.repository.CourseRepository;
import org.geeksforgeeks.crash_course_spring.repository.MentorRepository;
import org.geeksforgeeks.crash_course_spring.repository.StudentRepository;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnrolmentMapper {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public EnrolmentMapper(StudentRepository studentRepository , CourseRepository courseRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

  public Enrolment mapToModel(EnrolmentDto enrolmentDto) {
        Enrolment enrolment = new Enrolment();
      Student student = this.studentRepository.findById(enrolmentDto.getStudentId())
              .orElseThrow(() -> new NotFoundException("Student With ID:" + enrolmentDto.getStudentId() + "doesn't exist"));
      Course course = this.courseRepository.findById(enrolmentDto.getCourseId())
              .orElseThrow(() -> new NotFoundException("Course With ID:" + enrolmentDto.getCourseId() + "doesn't exist"));
      enrolment.setCourse(course);
      enrolment.setStudent(student);
      enrolment.setEnrolmentDate(enrolmentDto.getEnrolmentDate());
      enrolment.setStatus(enrolmentDto.getStatus());
      return enrolment;
  }

}
