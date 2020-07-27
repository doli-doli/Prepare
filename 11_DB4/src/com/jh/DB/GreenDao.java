package com.jh.DB;

import java.sql.*;
import java.util.*;
import java.util.List;



public class GreenDao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = null;

	private GreenDao() {
	}

	private static GreenDao dao = new GreenDao();

	public static GreenDao getInstance() {
		return dao;
	}

	private Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "root";
			String password = "admin";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public List<GreenDto> getAllList() {
		List<GreenDto> list = new ArrayList<GreenDto>();

		try {
			conn = getConnection();
			sql = "select * from green order by idx";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
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
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

		return list;

	}

	public GreenDto getOneList(String id) {
		GreenDto dto = null;

		try {
			conn = getConnection();
			sql = "select * from green where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
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
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

		return dto;
	}

	
	
	public int getInsert(GreenDto dto) {
		int result = 0;
		
	try {
		conn = getConnection();
		conn.setAutoCommit(false);
		
		sql = "insert into green values(green_seq.nextval,"+"?, ?, ?, ?, ?, sysdate)";
		
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
		try {
			if(conn != null) {conn.rollback();}
			e.printStackTrace();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}finally {
		try {
			if(ps != null) {ps.close();}
			if(conn != null) {
				conn.close();
				conn.setAutoCommit(true);
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		}
		return result;
	}
	
	
	
	
	public int getRemove(GreenDto dto) {
		int result = 0;
		
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			sql = "delete from green where id=? and pw=?";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			result = ps.executeUpdate();
			if(result > 0 ) {
				conn.commit();
			}
						
		} catch (Exception e) {
			try {
				if(conn != null) {conn.rollback();}
				e.printStackTrace();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				if(ps != null) {ps.close();}
				if(conn != null) {
					conn.close();
					conn.setAutoCommit(true);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			}
		
		
		return result;
	}
	
	
	
	
	public GreenDto getUpdateView(GreenDto dto) {
		GreenDto dto2 = null;
		
		try {
			conn = getConnection();
			sql = "select * from green where id=? and pw =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			rs = ps.executeQuery();

			if (rs.next()) {
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
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		
		return dto2;
	}
	
	
	public int getUpdate(GreenDto dto) {
		int result = 0;
		
		try {
			conn = getConnection();
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
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
		
		return result;
	}
	
	
	
	
}
