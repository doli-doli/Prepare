package com.jh.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class GuestbookDao {
	
	// field
	private static SqlSession sqlsession = null;
	
	// singleton
	private synchronized static SqlSession getSqlSession() { 			// synchronized : 동기화 된 
		if(sqlsession == null) {
			// DBService.getFactory(); : factory						// factory를 선언하지말고 아예 sqlSession에서 만들자!
		sqlsession = DBService.getFactory().openSession(false);			// .openSession(false) : 수동 커밋 
		}
		return sqlsession;
	}
	
	// Method
	// 모든 메소드를 static 처리해서 별도 과정없이 GuestbookDao.메소드명()으로 불러서 사용 할 수 있다!!!
	// sqlSession이 필요하면 위에서 정의한 getSqlSession()를 호출하면 된다! 
	
	// 1. 전체검색
	// <select id = "select_all" resultType="org.joonzis.mybatis.GuestbookDto">
	//		SELECT * FROM GUESTBOOK
	// </select> --> mapper에 작성
	public static List<GuestbookDto> select_all(){
		return getSqlSession().selectList("select_all");		  
	}
	
	// 2. 방명록 작성 
	// <insert id="insert">
	public static int getInsert(GuestbookDto dto) {
		int result = getSqlSession().insert("insert", dto);
		if(result > 0 ) {
			getSqlSession().commit();
		}
		return result;		
	}
	
	// 3. 방명록 보기 (idx에 의한 검색)
	// <select id = "select_by_idx"> 
	public static GuestbookDto selectByIdx(String idx) {
		return getSqlSession().selectOne("select_by_idx", idx);
	}
	
	// 4. 방명록 삭제
	//<delete id="remove_by_idx">
	public static int removeByIdx(int idx) {
		int result = getSqlSession().delete("remove_by_idx", idx);
		if(result > 0 ) {
			getSqlSession().commit();
		}
		return result;
	}
	
	// 5. 방명록 수정
	//<update id="update_by_idx">
	public static int updateByIdx(GuestbookDto dto) {
		int result = getSqlSession().update("update_by_idx", dto); 
		if(result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
}
