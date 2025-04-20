package com.example.Service.impl;

import com.example.Service.StudentService;
import com.example.entity.Student;
import com.example.repository.StudentRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    StudentRepository repository;

    @Override
    public List<Student> getStudentList() {
        return repository.findAll();
    }
}
