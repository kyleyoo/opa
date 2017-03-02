package com.wil.persistence;

import org.mybatis.spring.SqlSessionTemplate;

import com.wil.domain.MemberVO;

public class MemberDAO {
	
	public String namespace = "com.wil.persistence.MemberMapper";
	
	SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session){
		this.session = session;
	}
	
	public void insert(MemberVO vo){
		System.out.println("아마 여기는 잘 될테고");
		session.insert(namespace+".insertMember",vo);
		System.out.println("여기서 에러??");
	}
}
