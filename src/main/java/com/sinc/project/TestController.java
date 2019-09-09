package com.sinc.project;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sinc.project.test.service.TestServiceImpl;

@Controller
//RequestMapping("/bbs") 
public class TestController {
	
	@Resource(name="testS") 
	private TestServiceImpl service;
	
	@RequestMapping("/dependency.sinc")
	public String dependency(Model model) {
		System.out.println("test dependency");
		System.out.println(service.sayEcho("세이에코"));
		return "home";
	}
	
	@RequestMapping("/a.sinc")
	public String doA() {
		System.out.println("test main");
		return "/test/a";
	}
	
//	값을 뿌려주는 방법 1 : model에 값을 담아서 출력
	@RequestMapping("/index.sinc")
	public String main(Model model) {
		System.out.println("test main");
//		model의 scope은 request scope
		model.addAttribute("msg","hi~~~~~~");
		return "home";
	}
	
//	값을 뿌려주는 방법 2 : ModelAndView 객체 생성한 후 그 객체에 값을 담아서 출력
	@RequestMapping("/b.sinc")
	public ModelAndView doB() {
//		ModelAndVIew는 Model 객체와 똑같은 방식으로 값을 담아 뷰에 뿌리는 것
		System.out.println("test main");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		mv.addObject("msg", "Hi, model and view");
		return mv;
		
	}
	
	
	
	
}
