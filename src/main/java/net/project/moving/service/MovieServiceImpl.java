package net.project.moving.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.project.moving.dao.MovieDao;
import net.project.moving.domain.Netflix_movie;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	MovieDao movieDao;
	
	// 넷플릭스 영화목록 불러오기
	@Override
	public List<Netflix_movie> netflixmovielist() {
		List<Netflix_movie> list = movieDao.netflixmovielist();
		return list;
	}

}
