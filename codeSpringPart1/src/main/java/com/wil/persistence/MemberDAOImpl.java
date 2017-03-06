package com.wil.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.wil.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	//public String namespace = "com.wil.persistence.MemberMapper";
	@Inject
	SqlSessionTemplate session;
	
	
	
	@Override
	public String getTime() {
		 
		return session.selectOne("getTime");
	}



	@Override
	public void insert(MemberVO vo) {
		session.insert("insertMember",vo);
		
	}



	@Override
	public MemberVO selectMember(int mno) {
		
		return session.selectOne("selectMember", mno);
	}



	@Override
	public List<MemberVO> selectAll() {
		
		return session.selectList("selectAll");
	}



	@Override
	public void updateMember(MemberVO vo) {
		
		session.update("updateMember",vo);
	}



	@Override
	public void deleteMember(int mno) {
		session.delete("deleteMember",mno);
		
	}



	@Override
	public MemberVO readWithPW(String ID, String PW) throws Exception {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("ID", ID);
		paramMap.put("PW", PW);
		
		System.out.println(paramMap);
		return session.selectOne("readWithPW",paramMap);
	}

}
