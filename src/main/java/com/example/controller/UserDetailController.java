package com.example.controller;

import com.example.domain.user.model.MUser;
import com.example.domain.user.service.UserService;
import com.example.form.UserDetailForm;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserDetailController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    /** Display user details screen */
    @GetMapping("/detail/{userId:.+}")
    public String getUser(UserDetailForm form, Model model, @PathVariable ("userId") String userId) {

        // Get user
        MUser user = userService.getUserOne(userId);
        user.setPassword(null);

        // Get user
        form = modelMapper.map(user, UserDetailForm.class);

        // Registered in Model
        model.addAttribute("userDetailForm", form);

        // Display user details screen
        return "user/detail";
    }
}
