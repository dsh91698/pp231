package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "")
    public String showAllUsers(ModelMap model) {
        List<User> usersForShow = userService.selectAllUsersFromDatabase();
        model.addAttribute("users", usersForShow);
        return "users";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") Long id, ModelMap model) {
        User user = userService.getById(id);
        System.out.println(user);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping("")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }
}