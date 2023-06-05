package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    public CarsController() {}

    @GetMapping(value = "/users")
    public String printCars(@RequestParam(value = "count", defaultValue = "5") int count, ModelMap model) {
        List<User> usersForShow = userService.selectUsers(count);
        model.addAttribute("users", usersForShow);
        return "users";
    }
}