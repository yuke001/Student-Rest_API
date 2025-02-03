package com.yuke.Student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuke.Student.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	StudentRepository repository ;

}
