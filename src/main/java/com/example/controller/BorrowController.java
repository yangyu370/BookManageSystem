package com.example.controller;

import com.example.Service.BookService;
import com.example.Service.BorrowService;
import com.example.Service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BorrowController {
    @Resource
    BorrowService borrowService;
    @Resource
    StudentService studentService;
    @Resource
    BookService bookService;
    @RequestMapping(value = {"/borrow"})
    public String borrow(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname", user.getUsername());
        model.addAttribute("student_count",studentService.getStudentList().size());
        model.addAttribute("book_count",bookService.BookList().size());
        model.addAttribute("borrow_list", borrowService.BorrowList());
        return "borrow";
    }
    @RequestMapping(value="/add-borrow")
    public String addBorrow(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname",user.getUsername());
        model.addAttribute("borrow_list", borrowService.BorrowList());
        model.addAttribute("book_list",bookService.getAcitveBookList());
        model.addAttribute("student_list",studentService.getStudentList());
        return "add-borrow";
    }
    @PostMapping("/add-borrow")
    public String addBorrow(int student,int book){
        borrowService.addBorrow(book,student);
        return "redirect:/borrow";
    }
    @GetMapping("/return-book")
    public String returnBook(int id) {
        borrowService.deleteBorrow(id);
        return "redirect:/borrow";
    }
}
