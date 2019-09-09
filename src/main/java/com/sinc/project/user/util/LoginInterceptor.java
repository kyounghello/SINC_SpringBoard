package com.sinc.project.user.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		System.out.println("interceptor >>>>> post");
		HttpSession session = request.getSession();
		ModelMap model = modelAndView.getModelMap();
		Object obj = model.get("user");
		
		String dest = checkDestnation(request);
		String path = (dest != null)?dest:"/";
		
		if(obj != null) {
			System.out.println("Interceptor >>>>>> succeess !");
			session.setAttribute("loginUser", obj);
			response.sendRedirect(path);
		}else {
			response.sendRedirect("/user/loginForm.sinc");
		}
	}
	
	public String checkDestnation (HttpServletRequest request) {
		System.out.println("interceptor >>>>>>>> save path");
		
		HttpSession session = request.getSession();
		String savePath = (String)session.getAttribute("savePath");
		session.removeAttribute(savePath);
		System.out.println("login >>>>>>>>>>>>>>> getPath : " + savePath);
		return savePath;
	}
	
}
