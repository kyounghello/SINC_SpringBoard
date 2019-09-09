package com.sinc.project.test.model.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.sinc.project.test.model.vo.TestVO;

@Repository("dao")
public class DaoImpl {
	
//	mybatis가 관리하고 있는 해당 xml을 가져오는 것
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public void sampleRow() {
		System.out.println("dao sampleRow");
//		namespace에 select태그를 찾아가서 해당 내용을 수행하줌.
//		List<TestVO> list = session.selectList("com.sinc.test.select");
//		for(TestVO obj : list) {
//			System.out.println(obj);
//		}
		
		TestVO vo = new TestVO("sinc","sinc","신세계");
		int flag = session.insert("com.sinc.test.insert", vo);
		System.out.println(flag);
		
		
		
		
	}
}
