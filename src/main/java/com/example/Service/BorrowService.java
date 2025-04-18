package com.example.Service;

import com.example.entity.Borrow;

import java.util.List;

public interface BorrowService {
    List<Borrow> BorrowList();
    void addBorrow(int bid,int sid);
    void deleteBorrow(int id);
}
