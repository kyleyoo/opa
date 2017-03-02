package com.wil.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wil.domain.MemberVO;
import com.wil.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})	
public class memberTest {
	
	@Inject
	MemberDAO dao;

	@Test
	public void testInsert() {
		MemberVO vo = new MemberVO();
		
		vo.setName("김진수");
		vo.setGender("W");
		vo.setId("cow");
		vo.setAge(22);
		vo.setPw("123456");
		
		System.out.println("이름은:"+vo.getName()+"   성별은"+vo.getGender()+"    비번은"+vo.getPw());
		dao.insert(vo);
	}
	
	

}
