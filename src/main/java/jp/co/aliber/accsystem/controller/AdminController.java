package jp.co.aliber.accsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "login";
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String register() {
        return "register";
    }

}
