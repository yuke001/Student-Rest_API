package com.yuke.Student.service;

import com.yuke.Student.dto.Student;
import com.yuke.Student.exception.StudentNotFoundException;
import com.yuke.Student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    // Create a new student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

//    // Get student by ID
//    public Optional<Student> getStudentById(Long id) {
//        return studentRepository.findById(id);
//    }
//
//    // Update student
//    public Student updateStudent(Long id, Student updatedStudent) {
//        if (studentRepository.existsById(id)) {
//            updatedStudent.setId(id); // Ensure the ID is set to the existing student
//            return studentRepository.save(updatedStudent);
//        } else {
//            throw new RuntimeException("Student not found with id: " + id);
//        }
//    }

    
 // In StudentService.java
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
    }

    public Student updateStudent(Long id, Student updatedStudent) {
        if (studentRepository.existsById(id)) {
            updatedStudent.setId(id); // Ensure the ID is set to the existing student
            return studentRepository.save(updatedStudent);
        } else {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
    }
    // Delete student
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}