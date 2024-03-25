package com.mycompany.mywebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.mycompany.mywebapp.entity.User;
import com.mycompany.mywebapp.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    @Autowired private UserService uService;

    @GetMapping("/users")
    public String getListPage(Model model) {
        List<User> users = uService.listAll();
        model.addAttribute("listUsers", users);
        return "list-users";
    }
    
}
