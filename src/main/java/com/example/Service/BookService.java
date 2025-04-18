package com.example.Service;

import com.example.entity.Books;
import com.example.entity.Borrow;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookService {
    List<Books> BookList();
    List<Books> getAcitveBookList();
    void addBook(String title,String desc,double price);
    void deleteBook(int bid);
    List<Books> searchBook(String keyword);
    Page<Books> getBooksPage(int page, int size);
}
