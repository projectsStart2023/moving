package net.project.moving.dao;

import org.apache.ibatis.annotations.Mapper;

import net.project.moving.domain.User;

@Mapper
public interface UserDao {

	public void signUp(User user);

	
}
