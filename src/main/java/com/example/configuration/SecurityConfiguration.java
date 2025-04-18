package com.example.configuration;

import com.example.Service.UserAuthService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;


@Configuration
public class SecurityConfiguration {
    @Resource
    UserAuthService service;
    @Bean
    public PersistentTokenRepository persistentTokenRepository(DataSource dataSource) {
        JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
        repository.setDataSource(dataSource);
        //repository.setCreateTableOnStartup(true); // 第一次启动时创建表
        return repository;
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder coder = new BCryptPasswordEncoder();
//        System.out.println(coder.encode("123456"));
        return coder;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,PersistentTokenRepository repository) throws Exception {
        return http
                //以下是验证请求拦截和放行配置
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/static/**").permitAll();
                    auth.anyRequest().authenticated();//将所有请求全部拦截，一律需要验证
                })
                //以下是表单登录相关配置
                .formLogin(conf -> {
                    conf.loginPage("/login");   //将登录页设置为我们自己的登录页面
                    conf.loginProcessingUrl("/doLogin"); //登录表单提交的地址，可以自定义
                    conf.defaultSuccessUrl("/books");//登录成功后跳转的页面
                    conf.failureUrl("/error");
                    conf.permitAll();    //将登录相关的地址放行，否则未登录的用户连登录界面都进不去
                    //用户名和密码的表单字段名称，不过默认就是这个，可以不配置，除非有特殊需求
                    conf.usernameParameter("username");
                    conf.passwordParameter("password");
                })
                .rememberMe(conf->{
                    conf.tokenRepository(repository);
                    conf.tokenValiditySeconds(60*60*24*7);
                })
                .logout(config->{
                    config.logoutUrl("/doLogout");
                    config.logoutSuccessUrl("/login");
                    config.permitAll();
                })
                .userDetailsService(service)
                .csrf(AbstractHttpConfigurer::disable)
                .build();
    }
}
