package com.wil.persistence;

import java.util.List;

import com.wil.domain.MemberVO;

public interface MemberDAO {
	
	public String getTime();
	
	public void insert(MemberVO vo);
	
	public MemberVO selectMember(int mno);
	
	public List<MemberVO> selectAll();
	
	public void updateMember(MemberVO vo);
	
	public void deleteMember(int mno);
	
	public MemberVO readWithPW(String ID,String PW)throws Exception;

}
