package com.demo.JWTTokenUsingDatabse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.JWTTokenUsingDatabse.beans.MyUser;

@Repository
public interface LoginDao extends JpaRepository<MyUser,String>{
	@Query(value="select * from user1 where uname=:username",nativeQuery=true)
	MyUser findByUname(String username);
}
