package com.jh.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ex06_delete {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;
		String sql = null;
		int result = 0;
		
		try {
			conn = DBConnect.getConnection();
			sql = "delete from green";
			ps = conn.prepareStatement(sql);
			result = ps.executeUpdate();
			if ( result > 0 ) {
				System.out.println("전체 삭제가 완료되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}