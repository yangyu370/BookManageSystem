package com.example.Service.impl;

import com.example.Service.UserService;
import com.example.entity.Account;
import com.example.repo.AccountRepository;
import jakarta.annotation.Resource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    AccountRepository repository;
    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public boolean isUsernameExists(String username) {
        return repository.existsByUsername(username);
    }

    @Override
    public boolean isEmailExists(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public boolean registerUser(Account account) {
        try {
            account.setStudentInfo(account.getUsername(), account.getEmail(), "武装直升机", 1); // 默认性别和年级
            account.setPassword(passwordEncoder.encode(account.getPassword()));
            repository.save(account);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
