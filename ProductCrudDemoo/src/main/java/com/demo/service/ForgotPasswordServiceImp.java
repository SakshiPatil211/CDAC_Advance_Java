package com.demo.service;

import com.demo.dao.ForgotPasswordDao;
import com.demo.dao.ForgotPasswordDaoImp;

public class ForgotPasswordServiceImp implements ForgotPasswordService{
	private ForgotPasswordDao fdao;
	
	public ForgotPasswordServiceImp() {
		fdao = new ForgotPasswordDaoImp();
	}

	@Override
	public int resetPassword(String uname, String pass) {
		return fdao.resetPass(uname, pass);
	}
}
