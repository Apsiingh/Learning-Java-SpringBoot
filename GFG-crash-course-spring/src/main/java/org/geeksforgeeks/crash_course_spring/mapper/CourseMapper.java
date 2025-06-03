package org.geeksforgeeks.crash_course_spring.mapper;

import org.geeksforgeeks.crash_course_spring.dto.CourseDto;
import org.geeksforgeeks.crash_course_spring.entites.Course;
import org.geeksforgeeks.crash_course_spring.entites.Mentor;
import org.geeksforgeeks.crash_course_spring.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    // To convert CourseDto to Course
    private final MentorRepository mentorRepository;

    @Autowired
    public CourseMapper(MentorRepository mentorRepository){
        this.mentorRepository = mentorRepository;
    }

    public Course mapTopModle(CourseDto courseDto){
        Course course = new Course();
        Mentor mentor = this.mentorRepository.findById(courseDto.getMentorId()).orElse(null);
        course.setName(courseDto.getName());
        course.setPrice(courseDto.getPrice());
        course.setCapacity(courseDto.getCapacity());
        course.setNoOfDays(courseDto.getNoOfDays());
        course.setStartDate(courseDto.getStartDate());
        course.setDescription(courseDto.getDescription());
        course.setMentor(mentor);
        course.setEnrolmentEndDate(courseDto.getEnrolmentEndDate());
        return course;
    }

}
