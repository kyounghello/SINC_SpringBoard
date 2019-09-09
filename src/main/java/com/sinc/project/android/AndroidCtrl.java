package com.sinc.project.android;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinc.project.user.model.vo.UserVO;

@Controller
public class AndroidCtrl {
	@RequestMapping("/android.sinc")
	@ResponseBody
	public UserVO androidRequest(UserVO user) {
		System.out.println("native request call~~~~~~");
		System.out.println("param >> " + user);
		
		UserVO result = new UserVO();
		result.setId("response id");
		result.setPwd("response pwd");
		return result;
	}
}
