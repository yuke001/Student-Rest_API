package com.yuke.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuke.Student.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
