package com.jh.DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jh.DB.GreenDto;


public class GreenDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = null;
	
	private GreenDao() {}
	private static GreenDao dao = new GreenDao();
	
	public static GreenDao getInstance() {
		return dao;
	}
	
	//DBCP 설정
	private static DataSource ds;
	static {
		try {
			Context context = new InitialContext();
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	private void close1(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			if(rs != null) {rs.close();}
			if(ps != null) {rs.close();}
			if(conn != null) {conn.close();}
			
		}catch (Exception e) {
		}
	}
	
	
	private void close2(PreparedStatement ps, Connection conn) {
		try {
			if(ps != null) {rs.close();}
			if(conn != null) {
				conn.setAutoCommit(true);
				conn.close();
			}
			
		}catch (Exception e) {
		}
	}
	
	public List<GreenDto> getAllList() {
		List<GreenDto> list = new ArrayList<GreenDto>();
		
		try {
			//conn = getConnection(); -- 이전방식
			conn = ds.getConnection(); // 생성이 아니라 얻어옴
			sql = "select * from green order by reg_date desc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				GreenDto dto = new GreenDto();
				dto.setIdx(rs.getInt("idx"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setAddr(rs.getString("addr"));
				dto.setReg_date(rs.getDate("reg_date"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close1(rs, ps, conn);
		}
		return list;
	}
	
	
	public GreenDto getOneList(String id) {
		GreenDto dto = null;
		
		try {
			conn = ds.getConnection();
			sql = "select * from green where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new GreenDto();
				dto.setIdx(rs.getInt("idx"));
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getString("pw"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getInt("age"));
				dto.setAddr(rs.getString("addr"));
				dto.setReg_date(rs.getDate("reg_date"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close1(rs, ps, conn);
		}
		return dto;
	}
	
	
	public int getInsert(GreenDto dto) {
		int result = 0;
		
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			sql = "insert into green values(green_seq.nextval,"+
										"?, ?, ?, ?, ?, sysdate)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getAddr());
			
			result = ps.executeUpdate();
			if(result > 0) {
				conn.commit();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close2(ps, conn);
		}
		return result;
	}
	
	
	public int getRemove(String id,String pw) {
		int result = 0;
		
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			sql = "delete from green where id= ? and pw = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pw);
			result = ps.executeUpdate();
			if(result > 0) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				close1(rs, ps, conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	
	public GreenDto update_page(GreenDto dto) {
		GreenDto dto2 = null;
		
		try {
			conn = ds.getConnection();
			sql = "select * from green where id= ? and pw= ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto2 = new GreenDto();
				dto2.setIdx(rs.getInt("idx"));
				dto2.setId(rs.getString("id"));
				dto2.setPw(rs.getString("pw"));
				dto2.setName(rs.getString("name"));
				dto2.setAge(rs.getInt("age"));
				dto2.setAddr(rs.getString("addr"));
				dto2.setReg_date(rs.getDate("reg_date"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close1(rs, ps, conn);
		}
		return dto2;
	}
	
	
	public int getUpdate(GreenDto dto) {
		int result = 0;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			sql = "update green set pw = ?, name = ?, age = ?, addr = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getPw());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getAge());
			ps.setString(4, dto.getAddr());
			ps.setString(5, dto.getId());
			result = ps.executeUpdate();
			if(result > 0 ) {
				conn.commit();
			}
			
		}catch(Exception e ) {
			e.printStackTrace();
		} finally {
			try {
				close1(rs, ps, conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		return result;
	} 
	
	
	
	
}
