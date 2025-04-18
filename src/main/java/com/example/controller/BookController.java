package com.example.controller;

import com.example.Service.BookService;
import com.example.entity.Books;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class BookController {
    @Resource
    BookService service;
    @RequestMapping(value = "/books",method = RequestMethod.GET)
    public String books(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname",user.getUsername());
        model.addAttribute("book_list", service.BookList());
        return "books";
    }
    @GetMapping("/add-book")
    public String addBook(Model model){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("nickname",user.getUsername());
        return "add-book";
    }
    @PostMapping("/add-book")
    public String addBook(String title,String desc,double price){
        service.addBook(title,desc,price);
        return "redirect:/books";
    }
    @GetMapping("/delete-book")
    public String deleteBook(int bid){
        service.deleteBook(bid);
        return "redirect:/books";
    }
    @GetMapping("/search-book")
    public String searchBook(@RequestParam String keyword,Model model){
        List<Books> list=service.searchBook(keyword);
        model.addAttribute("book_list",list);
        return "/search-book";
    }
}
