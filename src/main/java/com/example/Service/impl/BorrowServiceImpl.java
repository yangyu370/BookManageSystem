package com.example.Service.impl;

import com.example.Service.BorrowService;
import com.example.entity.Books;
import com.example.entity.Borrow;
import com.example.entity.Student;
import com.example.repo.BookRepository;
import com.example.repo.BorrowRepository;
import com.example.repo.StudentRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BorrowServiceImpl implements BorrowService {
    @Resource
    BorrowRepository borrowRepository;
    @Resource
    StudentRepository studentRepository;
    @Resource
    BookRepository bookRepository;
    @Override
    public List<Borrow> BorrowList() {
        return borrowRepository.findAll();
    }
    @Override
    public void addBorrow(int bid, int sid) {
        Student student = studentRepository.findById(sid)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + sid));
        Books book = bookRepository.findById(bid)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + bid));

        book.setStatus("borrowed");
        bookRepository.save(book);

        Borrow borrow = new Borrow();
        borrow.setStudent(student);
        borrow.setBook(book);
        borrow.setTime(new Date());

        borrowRepository.save(borrow);
    }

     @Override
     public void deleteBorrow(int id) {
     Books book=borrowRepository.findById(id).get().getBook();
     book.setStatus("allowed");
     bookRepository.save(book);
     borrowRepository.deleteById(id);
    }
}
