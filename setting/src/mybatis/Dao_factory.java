package mybatis;

import org.apache.ibatis.session.SqlSessionFactory;


public class Dao_factory {

	private SqlSessionFactory factory = null;
	
	private Dao_factory() {
		factory = DBService.getFactory();
	}
	
	private static Dao_factory dao = new Dao_factory();
	public static Dao_factory getInstance() {
		return dao;
	}
	
	
}
