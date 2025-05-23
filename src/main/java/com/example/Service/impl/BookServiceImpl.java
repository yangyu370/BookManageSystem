package com.example.Service.impl;

import com.example.Service.BookService;
import com.example.entity.Books;
import com.example.repository.BookRepository;
import jakarta.annotation.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookRepository repository;

    @Override
    public List<Books> BookList() {
        List<Books> list=repository.findAll();
        return list;
    }

    @Override
    public List<Books> getAcitveBookList() {
        List<Books> list=repository.findByStatus("allowed");
        return list;
    }

    @Override
    public void addBook(String title, String desc, double price) {
       Books book=new Books();
       book.setTitle(title);
       book.setDesc(desc);
       book.setPrice(price);
       book.setStatus("allowed");
       repository.save(book);
    }

    @Override
    public void deleteBook(int bid) {
        repository.deleteById(bid);
    }

    @Override
    public List<Books> searchBook(String keyword) {
      return repository.findByTitleContaining(keyword);
    }
    @Override
    public Page<Books> getBooksPage(int page, int size) {
        Pageable pageable = PageRequest.of(Math.max(page, 0), size); // page已经是0基
        return repository.findAll(pageable);
    }
}
