package com.demo.service;

import com.demo.beans.Users;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImp;

public class LoginServiceImp implements LoginService {
	private LoginDao ldao;
	
	public LoginServiceImp() {
		ldao = new LoginDaoImp();
	}

	@Override
	public Users validateUser(String uname, String pass) {
		return ldao.checkUser(uname,pass);
	}
}
