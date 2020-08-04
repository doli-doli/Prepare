package com.jh.mybatis.config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {	// factory를 만드는게 목적이다.
	//Field
	private static SqlSessionFactory factory = null;
	
	//singleton
	static {
		try {
			String resource = "com/jh/mybatis/config/sqlmap.xml";
			InputStream is = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// method
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
	// SqlSessionFactoryBuilder에서 SqlSessionFactory를 생성하고,
	// Factory에서 SqlSession을 생성한다.
	// mybatis를 이용하려면 SqlSession이 필요하다.
	
}
