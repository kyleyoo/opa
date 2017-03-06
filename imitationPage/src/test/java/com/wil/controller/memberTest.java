package com.wil.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wil.domain.MemberVO;
import com.wil.persistence.MemberDAOImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})	
public class memberTest {
	
	@Inject
	private SqlSession session;
	
	@Inject
	MemberDAOImpl dao;

	@Test
	public void testInsert() {
		MemberVO vo = new MemberVO();
		
		vo.setName("에비앙");
		vo.setGender("W");
		vo.setId("evian");
		vo.setAge(12);
		vo.setPw("123456");
		
		System.out.println("이름은:"+vo.getName()+"   성별은"+vo.getGender()+"    비번은"+vo.getPw());
		dao.insert(vo);
	}
	
	@Test
	public void testSelectOne(){
		System.out.println(dao.selectMember(4));
		
	}
	
	@Test
	public void testSelectAll(){
		List<MemberVO> list = dao.selectAll();
		
		for(MemberVO memberVO1 : list){
			System.out.println(memberVO1);
		}
	}
	
	@Test
	public void testUpdate(){
		MemberVO vo = new MemberVO();
		
		vo.setAge(40);
		vo.setGender("M");
		vo.setId("huy");
		vo.setName("카리스마");
		vo.setPw("1212");
		vo.setMno(7);
		
		dao.updateMember(vo);
	}
	
	@Test
	public void testDelete(){
		dao.deleteMember(7);
	}
	
	@Test
	public void  getTime(){
		 dao.getTime();
	}
	
	@Test
	public void testGetIDPW() throws Exception{
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
	
		
		dao.readWithPW("'KYLE'", "'123456'");
		
		
		
	}

}
