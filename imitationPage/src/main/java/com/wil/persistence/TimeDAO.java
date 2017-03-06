package com.wil.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Repository;




public class TimeDAO {
	
	private DataSource ds;
	
	public void setDs(DataSource ds){
		this.ds=ds;
	}
	
	public String getTime()throws Exception{
		
		Connection con = ds.getConnection();
		
		PreparedStatement pstmt = con.prepareStatement("select now()");
		
		ResultSet rs = pstmt.executeQuery();
		
		rs.next();
		
		return rs.getString(1);
	}
	
	

}
