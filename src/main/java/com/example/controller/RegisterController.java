package com.example.controller;

import com.example.Service.RegisterService;
import com.example.Service.UserService;
import com.example.entity.Account;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegisterController {
    @Resource
    RegisterService registerService;
    @Resource
    UserService userService;

    @RequestMapping(value="/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }
    @PostMapping("/register")
    public String doregister(@RequestParam("username") String username, @RequestParam("email")String email, @RequestParam("password")String password, @RequestParam("verifyCode")String verifyCode){
        if(!registerService.doVerify(email, verifyCode)) {
            return "redirect:/register?error=CodeOutofTime";
        }
        // 检查用户名是否已存在
        if(userService.isUsernameExists(username)) {
            return "redirect:/register?error=UsernameExists";
        }

        // 检查邮箱是否已被注册
        if(userService.isEmailExists(email)) {
            return "redirect:/register?error=EmailExists";
        }
        // 创建新用户并保存
        Account account = new Account();
        account.setUsername(username);
        account.setEmail(email);
        account.setPassword(password);
        account.setRole("user");
        if(userService.registerUser(account)) {
            // 注册成功，重定向到登录页面
            return "redirect:/login?success";
        } else {
            // 注册失败
            return "redirect:/register?error";
        }
    }
    @GetMapping("/api/auth/verify-code")
    @ResponseBody
    public ResponseEntity<String> sendVerifyCode(@RequestParam("email") String email) {
        try {
            registerService.sendVerifyCode(email);
            return ResponseEntity.ok().body("验证码已发送");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("发送验证码失败: " + e.getMessage());
        }
    }
}
