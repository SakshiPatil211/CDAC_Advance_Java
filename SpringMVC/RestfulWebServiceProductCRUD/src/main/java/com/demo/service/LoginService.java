package com.demo.service;

import com.demo.beans.User;

public interface LoginService {

	User validateUsers(String uname, String pass);

}
