package com.demo.service;

import com.demo.beans.Users;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImp;

public class LoginServiceImp implements LoginService{
	LoginDao ldao;
	
	public LoginServiceImp() {
		ldao = new LoginDaoImp();
	}
	
	@Override
	public Users validateuser(String uname, String pass) {
		return ldao.checkUser(uname,pass);
	}

}
