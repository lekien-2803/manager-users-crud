package com.mycompany.mywebapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.mycompany.mywebapp.entity.User;
import com.mycompany.mywebapp.exception.UserNotFoundException;
import com.mycompany.mywebapp.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class UserController {
    @Autowired private UserService uService;

    // Read - GET: Hiển thị danh sách người dùng
    @GetMapping("/users")
    public String getListPage(Model model) {
        List<User> users = uService.listAll();
        model.addAttribute("listUsers", users);
        return "list-users";
    }

    // Create - GET: Hiển thị trang thêm mới người dùng
    @GetMapping("/users/new")
    public String getNewUserPage(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "Add User");
        return "user-form";
    }

    // Create - POST: Lưu người dùng mới
    @PostMapping("/users/save")
    public String saveNewUser(User user, RedirectAttributes ra) {
        uService.save(user);
        ra.addFlashAttribute("message", "The user has been saved successfully.");
        return "redirect:/users";
    }
    
    // Update - GET: Hiển thị trang chỉnh sửa thông tin người dùng
    @GetMapping("/users/edit/{id}")
    public String getEditUserPage(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            User user = uService.getUserById(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Edit User ID:" + id);
            return "user-form";
        } catch (UserNotFoundException e) {
            ra.addFlashAttribute("message", "The user has been saved successfully.");
            return "redirect:/users";
        }
    }

    // Update - POST: Cập nhật thông tin người dùng
    @PostMapping("users/edit/{id}")
    public String editUser(@PathVariable("id") Integer id,@ModelAttribute("user") User user, RedirectAttributes ra) {
        uService.save(user);
        ra.addFlashAttribute("message", "The user has been saved successfully.");
        return "redirect:/users";
    }

    // Delete - DELETE: Xóa người dùng
    @GetMapping("users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes ra){
        uService.deleteUser(id);
        ra.addFlashAttribute("message", "The user with id: " + id + " has been deleted successfully.");
        return "redirect:/users";
    }
    
}
