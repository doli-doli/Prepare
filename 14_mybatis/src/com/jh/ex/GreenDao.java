package com.jh.ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class GreenDao {

	private SqlSessionFactory factory = null;
	
	private GreenDao() {
		factory = DBService.getFactory();
	}
	
	private static GreenDao dao = new GreenDao();
	public static GreenDao getInstance() {
		return dao;
	}

	//1. 전체 검색
	public List<GreenDto> selectAll(){
		SqlSession sqlSession = factory.openSession();
		List<GreenDto> list = sqlSession.selectList("select_all");
		sqlSession.close();
		return list;
	}
	
	//2. 회원 검색
	public GreenDto selectById(String id) {
		SqlSession sqlSession = factory.openSession();
		GreenDto dto = sqlSession.selectOne("select_by_id", id);
		sqlSession.close();
		return dto;
	}
	
	//3. 회원 추가
	public int insert(GreenDto dto) {
		SqlSession sqlSession = factory.openSession(false);
		int result = sqlSession.insert("insert", dto);
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	//4. 회원 삭제
	public int remove(GreenDto dto) {
		SqlSession sqlSession = factory.openSession(false);
		int result = sqlSession.delete("remove", dto);
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	//5. 회원 정보 수정 페이지
	public GreenDto update_page(GreenDto dto) {
		SqlSession sqlSession = factory.openSession();
		GreenDto dto2 = sqlSession.selectOne("update_page",dto);
		sqlSession.close();
		return dto2;
	}
	
	//6. 회원 정보 수정
	public int update(GreenDto dto) {
		SqlSession sqlSession = factory.openSession();
		int result = 0;
		result = sqlSession.update("update",dto);
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
