package net.project.moving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.project.moving.domain.User;
import net.project.moving.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;

	@GetMapping("/user/signIn")
	public String signIn() {
		return "/user/signIn";
	}
	
	@GetMapping("/user/signUp")
	public String signUp() {
		return "/user/signUp";
	}
	
	@PostMapping("/user/signUp")
	public String signUp(User user) {
		service.signUp(user);
		return "redirect:/";
	}
}
