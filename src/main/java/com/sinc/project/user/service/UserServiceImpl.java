package com.sinc.project.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sinc.project.user.model.sql.UserDao;
import com.sinc.project.user.model.vo.UserVO;

@Service("userS")
public class UserServiceImpl implements UserService{

	@Resource(name="userD")
	private UserDao dao ; 
	
	@Override
	public UserVO loginService(UserVO user) {
		System.out.println("user service login");
		return dao.loginRow(user);
	}
	
}


