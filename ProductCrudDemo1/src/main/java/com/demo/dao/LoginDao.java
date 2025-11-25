package com.demo.dao;

import com.demo.beans.Users;

public interface LoginDao {

	Users checkUser(String uname, String pass);

}
