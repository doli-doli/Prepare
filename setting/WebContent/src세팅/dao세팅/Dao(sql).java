package com.jh.dao;

import org.apache.ibatis.session.SqlSession;
import com.jh.mybatis.config.DBService;

public class Dao {

		private static SqlSession sqlsession = null;
		private synchronized static SqlSession getSqlSession() {
			if(sqlsession == null) {
				sqlsession = DBService.getFactory().openSession(false);
			}
			return sqlsession;
		}
}
