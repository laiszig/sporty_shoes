package com.laiszig.sporty_shoes.controller;

import com.laiszig.sporty_shoes.entity.User;
import com.laiszig.sporty_shoes.formData.CredentialFormData;
import com.laiszig.sporty_shoes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String create(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/user")
    public String addUser(User user, RedirectAttributes redirectAttributes) {
        userService.saveUser(user);
        redirectAttributes.addFlashAttribute("message", "added");
        return "redirect:/login";
    }

    @GetMapping("/user/changepassword")
    public String changePassword(Model model) {
        model.addAttribute("credential", new CredentialFormData());
        return "changePassword";
    }

    @PostMapping("/user/changepassword")
    public String changePassword(CredentialFormData credentialFormData, RedirectAttributes redirectAttributes) {
        userService.updatePassword(credentialFormData);
        return "redirect:/login";
    }
}
