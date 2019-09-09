package com.sinc.project.user.model.sql;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sinc.project.board.model.sql.BoardDao;
import com.sinc.project.user.model.vo.UserVO;

@Repository("userD")
public class UserDaoImpl implements UserDao{

	@Autowired
	private SqlSession session;

	@Override
	public UserVO loginRow(UserVO user) {
		// TODO Auto-generated method stub
		return session.selectOne("com.sinc.user.login", user);
	}
	
	

	
}
