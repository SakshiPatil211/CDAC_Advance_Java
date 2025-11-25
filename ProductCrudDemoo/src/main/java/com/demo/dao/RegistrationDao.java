package com.demo.dao;

import com.demo.beans.Users;

public interface RegistrationDao {

	int store(int uid,String uname,String email,String pass);
}
