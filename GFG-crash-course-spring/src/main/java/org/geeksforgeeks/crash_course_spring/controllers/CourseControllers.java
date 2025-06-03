package org.geeksforgeeks.crash_course_spring.controllers;


import jakarta.validation.Valid;
import org.geeksforgeeks.crash_course_spring.dto.CourseDto;
import org.geeksforgeeks.crash_course_spring.entites.Course;
import org.geeksforgeeks.crash_course_spring.mapper.CourseMapper;
import org.geeksforgeeks.crash_course_spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseControllers {

    private final CourseService courseService;
    private final CourseMapper courseMapper;

    @Autowired
    public CourseControllers(CourseService courseService , CourseMapper courseMapper){
        this.courseService = courseService;
        this.courseMapper = courseMapper;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody @Valid CourseDto courseDto){
        // Convert courseDto to course
        Course course = this.courseMapper.mapTopModle(courseDto);
        return  new ResponseEntity<>(this.courseService.addCourse(course) , HttpStatus.CREATED);
    }

}
