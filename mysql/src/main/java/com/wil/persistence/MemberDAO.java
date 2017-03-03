package com.wil.persistence;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

import com.wil.domain.MemberVO;

public class MemberDAO {
	
	//public String namespace = "com.wil.persistence.MemberMapper";
	
	SqlSessionTemplate session;
	
	public void setSession(SqlSessionTemplate session){
		this.session = session;
	}
	
	public void insert(MemberVO vo){
		session.insert("insertMember",vo);
	}
	
	public MemberVO selectMember(int mno){
		return session.selectOne("selectMember", mno);
	}
	
	public List<MemberVO> selectAll(){
		return session.selectList("selectAll");
	}
	
	public void updateMember(MemberVO vo){
		session.update("updateMember",vo);
	}
	
	public void deleteMember(int mno){
		session.delete("deleteMember",mno);
	}
}
