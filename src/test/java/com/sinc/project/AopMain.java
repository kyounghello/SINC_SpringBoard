package com.sinc.project;
import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sinc.project.aop.core.SincService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = ("file:src/main/webapp/WEB-INF/spring/**/root-context.xml"))


public class AopMain {
	@Resource(name="serviceTarget")
	private SincService service;
	
	@Test
	public void caller() throws Exception {
		String msg = service.sayEcho("이게 AOP~~~");
		System.out.print(msg);
	}
	
	
}
