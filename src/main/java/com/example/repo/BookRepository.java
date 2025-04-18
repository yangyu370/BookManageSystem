package com.example.repo;

import com.example.entity.Books;
import com.example.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {

    List<Books> findByStatus(String status);

   List<Books> findByTitleContaining(String title);
}
