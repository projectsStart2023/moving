package net.project.moving.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import net.project.moving.domain.Netflix_movie;

@Mapper
public interface MovieDao {
	// 넷플릭스 영화목록 불러오기
	public List<Netflix_movie> netflixmovielist();
}
