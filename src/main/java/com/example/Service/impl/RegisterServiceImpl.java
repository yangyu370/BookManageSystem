package com.example.Service.impl;

import com.example.Service.RegisterService;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class RegisterServiceImpl implements RegisterService {
    private static final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);
    
    @Resource
    JavaMailSender sender;
    @Resource
    StringRedisTemplate template;
    
    @Override
    public void sendVerifyCode(String email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("[91图书管理系统网站]您的注册验证码：");
            Random random = new Random();
            int code = random.nextInt(899999) + 100000;
            template.opsForValue().set("register:verifyCode:" + email, code + "", 3, TimeUnit.MINUTES);
            message.setText("您的验证码为" + code + ",3分钟内有效请及时完成注册,如果不是本人操作请忽略");
            message.setTo(email);
            message.setFrom("13607563956@163.com");
            
            logger.info("正在向邮箱 {} 发送验证码", email);
            sender.send(message);
            logger.info("验证码发送成功");
        } catch (Exception e) {
            logger.error("发送验证码邮件失败: {}", e.getMessage(), e);
            throw new RuntimeException("邮件发送失败: " + e.getMessage(), e);
        }
    }
    @Override
    public Boolean doVerify(String email, String code) {
        String str=template.opsForValue().getAndDelete("register:verifyCode:" + email);
        if(str==null){
            return false;
        }
        return str.equals(code);
    }
}
