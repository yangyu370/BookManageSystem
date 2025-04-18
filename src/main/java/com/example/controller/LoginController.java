package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(){
        return "login";
    }
    @RequestMapping(value={"/index"},method = RequestMethod.GET)
    public String index(){
        return "index";
    }
    @RequestMapping()
    public String error(){
        return "error";
    }
}
