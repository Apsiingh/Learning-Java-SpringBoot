package org.geeksforgeeks.crash_course_spring.service;

import org.geeksforgeeks.crash_course_spring.entites.Student;
import org.geeksforgeeks.crash_course_spring.exceptions.NotFoundException;
import org.geeksforgeeks.crash_course_spring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student){
        return this.studentRepository.save(student);
    }

    public Student getStudentById(long studentId){
        Optional<Student> optionalValue = this.studentRepository.findById(studentId);
        return  optionalValue.orElseThrow( ()-> {
          return  new NotFoundException("Student with Id: "+ studentId +" was not Found.");
        });
    }

    public Student updateStudentById(Student updatedStudent) {
        Student existingStudent = studentRepository.findById(updatedStudent.getId())
                .orElseThrow(() -> new NotFoundException("Student ID not exist"));

        existingStudent.setFirstName(updatedStudent.getFirstName());
        existingStudent.setLastName(updatedStudent.getLastName());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudentById(long studentId) {
        if (!studentRepository.existsById(studentId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found with ID: " + studentId);
        }
        studentRepository.deleteById(studentId);
    }

}
