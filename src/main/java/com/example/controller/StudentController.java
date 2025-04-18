package com.example.controller;

import com.example.Service.StudentService;
import com.example.entity.Student;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @Resource
    StudentService service;
    @RequestMapping("/student")
    public String student(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname",user.getUsername());
        model.addAttribute("student_list",service.getStudentList());
        return "student";
    }
}
