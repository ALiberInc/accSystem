package jp.co.aliber.accsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.aliber.accsystem.entity.auto.User;
import jp.co.aliber.accsystem.form.UserInfoFrom;
import jp.co.aliber.accsystem.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		model.addAttribute("name", name);
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register() {
		return "register";
	}

	@RequestMapping(value = "/mybatistest", method = RequestMethod.GET)
	public String mybatisTest(Model model) {
		User firstUser = adminService.getFirstUser();
		model.addAttribute("userId", firstUser.getId());
		model.addAttribute("email", firstUser.getMail());
		return "useMybatis";
	}
	
	@RequestMapping(value = "/formtest", method = RequestMethod.GET)
	public String formTest(UserInfoFrom userForm) {
		User firstUser = adminService.getFirstUser();
		userForm.setId(firstUser.getId());
		userForm.setName("Jack");
		userForm.setEmail(firstUser.getMail());
		return "useForm";
	}
	
}
