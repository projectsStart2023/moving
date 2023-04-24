package net.project.moving.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.project.moving.domain.Netflix_movie;
import net.project.moving.domain.User;
import net.project.moving.service.MovieService;
import net.project.moving.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService service;

	// 로그인 페이지로 이동	
	@GetMapping("/user/signIn")
	public String signIn() {
		return "/user/signIn";
	}
	
	// 회원가입 페이지로 이동	
	@GetMapping("/user/signUp")
	public String signUp() {
		return "/user/signUp";
	}
	
	// 회원가입 처리
	@PostMapping("/user/signUp")
	public String signUp(User user) {
		service.signUp(user);
		return "redirect:/";
	}
	
	// 프로필 페이지 이동
	@GetMapping("/user/profile")
	public String profile() {
		return "/user/profile";
	}
}
