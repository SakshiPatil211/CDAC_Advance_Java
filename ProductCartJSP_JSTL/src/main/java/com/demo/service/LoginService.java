package com.demo.service;

import com.demo.beans.Users;

public interface LoginService {

	Users validateuser(String uname, String pass);

}
