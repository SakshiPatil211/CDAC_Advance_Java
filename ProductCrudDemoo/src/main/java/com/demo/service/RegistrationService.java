package com.demo.service;

import com.demo.beans.Users;

public interface RegistrationService {

	int save(int uid,String uname,String email,String pass);
}
