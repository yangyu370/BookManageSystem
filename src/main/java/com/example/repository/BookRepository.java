package com.example.repository;

import com.example.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Integer> {

    List<Books> findByStatus(String status);

   List<Books> findByTitleContaining(String title);
}
