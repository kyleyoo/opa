package com.wil.controller;

import static org.junit.Assert.fail;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wil.persistence.TimeDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})	
public class DAOTest {
	
	@Inject
	TimeDAO dao;

	@Test
	public void testTime()throws Exception{
		System.out.println(dao.getTime());
	}

}
