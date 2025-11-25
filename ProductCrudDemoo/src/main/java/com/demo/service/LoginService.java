package com.demo.service;

import com.demo.beans.Users;

public interface LoginService {

	Users validateUser(String uname, String pass);

}
