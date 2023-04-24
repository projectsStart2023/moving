package net.project.moving.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import net.project.moving.domain.Netflix_movie;
import net.project.moving.service.MovieService;

@Controller
public class MovieController {
	@Autowired
	MovieService movieService;

	// movie Home으로 이동 및 netflix_movie 불러오기
	@GetMapping("/movie/home")
	public String movieHome(Model model) {
		List<Netflix_movie> list = movieService.netflixmovielist();
		// 모델에 리스트 저장
		model.addAttribute("list", list);
		return "/movie/home";
	}
	
	

}
