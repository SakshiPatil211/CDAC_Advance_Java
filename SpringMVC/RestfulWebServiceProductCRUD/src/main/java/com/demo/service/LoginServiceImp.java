package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.User;
import com.demo.dao.LoginDao;

@Service
public class LoginServiceImp implements LoginService{
	@Autowired
	LoginDao ldao;

	public User validateUsers(String uname, String pass) {
		return ldao.validateUsers(uname,pass);
	}
}
