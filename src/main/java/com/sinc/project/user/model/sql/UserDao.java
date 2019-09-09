package com.sinc.project.user.model.sql;

import com.sinc.project.user.model.vo.UserVO;

public interface UserDao {
	public UserVO loginRow(UserVO user);
}
