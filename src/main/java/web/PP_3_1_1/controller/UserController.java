package web.PP_3_1_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.PP_3_1_1.service.UserService;
import web.PP_3_1_1.model.User;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam("name") String name, @RequestParam("lastName") String lastName, @RequestParam("age") byte age) {
        userService.saveUser(new User(name, lastName, age));
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id) {
        User user = userService.getUserById(id);
        if (user != null) {
            userService.removeUserById(id);
        }
        return "redirect:/";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User user) {
        userService.editUser(user);
        return "redirect:/";
    }
}