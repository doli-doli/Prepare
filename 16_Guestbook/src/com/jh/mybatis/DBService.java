package com.jh.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {
	
	// Field
	private static SqlSessionFactory factory;
	
	// static 초기화
	static {
		try {
			String resource = "com/jh/mybatis/sqlmap.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	// factory를 리턴하는 getFactory() 메소드
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
}
