package com.demo.service;
import com.demo.dao.RegistrationDao;
import com.demo.dao.RegistrationDaoImp;

public class RegistrationServiceImp implements RegistrationService{
	private RegistrationDao rdao;
	
	public RegistrationServiceImp() {
		rdao = new RegistrationDaoImp();
	}

	@Override
	public int save(int uid,String uname,String email,String pass) {
		return rdao.store(uid,uname,email,pass);
	}
}
