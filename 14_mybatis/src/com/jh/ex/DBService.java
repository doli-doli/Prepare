package com.jh.ex;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBService {

		private static SqlSessionFactory factory = null;
		
		
		static {
			try {
				String resource = "com/jh/ex/sqlmap.xml";
				InputStream is = Resources.getResourceAsStream(resource);
				factory = new SqlSessionFactoryBuilder().build(is);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	
		
		public static SqlSessionFactory getFactory() {
			return factory;
		}


		
		
		
		
		
		
		
}
