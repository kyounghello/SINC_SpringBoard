package com.sinc.project.user.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinc.project.user.model.vo.UserVO;
import com.sinc.project.user.service.UserService;

@Controller
@RequestMapping("/user")
//@SessionAttributes({"loginUser"}) // 인터셉터를 위한 annotation. model의 scope이 session scope으로 변하게 됨
public class UserCtrl {
	
	@Resource(name="sqlSession")
	private SqlSession session;
	
	@Resource(name="userS")
	private UserService service;
	
	@RequestMapping("/loginForm.sinc")
	public String loginForm() {
		return "/user/login";
	}
	
	@RequestMapping(value = "/login.sinc", method=RequestMethod.POST) //post방식으로 보내는 문법
	public void login(UserVO user, Model model) {
		System.out.println("user ctrl login");
		
		UserVO result = service.loginService(user);
		if(result != null) {
			model.addAttribute("user", result);
			
		}else {
//			아까 썼던 아이디 및 패스워드 그대로 유지하고 싶당....
		}

	}
	
//	위의 @SessionAttributes({"loginUser"})과 연결되는 세션 (스프링 개념의 세션 연결)
//	@RequestMapping("/logout.sinc")
//	public String logout(SessionStatus status) {
//		System.out.println("user ctrl logout");
//		status.setComplete();
//		return "redirect:/index.sinc";
//	}
	
//	웹 개념의 세션 연결
	@RequestMapping("/logout.sinc")
	public String logout(HttpSession session) {
		System.out.println("user ctrl logout");
		session.invalidate();
		return "redirect:/index.sinc";
	}
	

	
}
