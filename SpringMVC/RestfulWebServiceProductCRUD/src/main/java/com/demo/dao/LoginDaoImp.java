package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.User;

@Repository
public class LoginDaoImp implements LoginDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	public User validateUsers(String uname, String pass) {
		try {
			User u1 = jdbcTemplate.queryForObject("select * from user12 where uname=? and password=?",
					new Object[] {uname,pass}, BeanPropertyRowMapper.newInstance(User.class));
			System.out.println(u1);
			return u1;
		}catch(EmptyResultDataAccessException e) {
			System.out.println("USer not found");
			return null;
		}
		
	}

}
