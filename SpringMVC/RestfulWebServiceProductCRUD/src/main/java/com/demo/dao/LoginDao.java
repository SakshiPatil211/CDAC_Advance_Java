package com.demo.dao;

import com.demo.beans.User;

public interface LoginDao {

	User validateUsers(String uname, String pass);

}
