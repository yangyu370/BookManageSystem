package com.example.Service;

import com.example.entity.Account;
import com.example.repo.AccountRepository;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserAuthService implements UserDetailsService {
    @Resource
    AccountRepository repository;
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        Account account = repository.findAccountByUsername(usernameOrEmail);
        if (account == null) {
            account = repository.findAccountByEmail(usernameOrEmail);
        }
        if (account == null) {
            throw new UsernameNotFoundException("用户 " + usernameOrEmail + " 登录失败，用户名或邮箱不存在！");
        }
        return User
                .withUsername(account.getUsername())
                .password(account.getPassword())
                .roles(account.getRole())
                .build();
    }

}
