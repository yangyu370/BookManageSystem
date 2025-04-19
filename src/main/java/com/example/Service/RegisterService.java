package com.example.Service;

public interface RegisterService {
    void sendVerifyCode(String email);
    Boolean doVerify(String email,String code);
}
