package net.project.moving.service;

import java.util.List;

import net.project.moving.domain.Netflix_movie;


public interface MovieService {
	// 넷플릭스 영화목록 불러오기
	public List<Netflix_movie> netflixmovielist();

}
