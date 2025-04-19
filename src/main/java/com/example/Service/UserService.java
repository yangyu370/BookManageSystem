package com.example.Service;

import com.example.entity.Account;

public interface UserService {
    boolean isUsernameExists(String username);

    /**
     * 检查邮箱是否已被注册
     */
    boolean isEmailExists(String email);

    /**
     * 注册新用户
     */
    boolean registerUser(Account account);

}
