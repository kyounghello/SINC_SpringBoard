package com.sinc.project.board.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("interceptor >>>>>>>>>>>>> auth");
		HttpSession session = request.getSession();
		String path="/user/loginForm.sinc";
		if(session.getAttribute("loginUser") == null) {
			savePath(request);
			response.sendRedirect(path);
			return false;
		}
		
		return true;
	}
	
	
	public void savePath(HttpServletRequest request) {
		String uri = request.getRequestURI(); // uri만 가져옴. post 방식은 이걸로 끝남, 그러나 get방식일 경우 query를 가져오지 못함. 
		String queryString = request.getQueryString(); //따라서 get방식일 경우 query까지 가져오는 것. 그러나 ? 같은 문자는 못들어옴. 따라서 만들어줘야함
		if(queryString == null || queryString.equals("null")) {
			queryString = ""; //post 방식
		}else {
			queryString = "?" + queryString; // get방식
		}
		request.getSession().setAttribute("savePath", uri + queryString);
		System.out.println("auth >>>>>> savePath "+ uri + queryString);
	}
}
