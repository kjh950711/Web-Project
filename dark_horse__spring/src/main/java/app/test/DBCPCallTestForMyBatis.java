package app.test;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.support.GenericXmlApplicationContext;


public class DBCPCallTestForMyBatis {

	public static void main(String[] args) {
		DBCPCallTestForMyBatis db = new DBCPCallTestForMyBatis();
		SqlSession session = db.dbConn();
		if(session != null)
			System.out.println("dbcp-mybatis session ok");
		else 
			System.out.println("dbcp-mybatis session faild");
//		List<EmpVO> list = session.selectList("EmpMapper.empListSQL" );
//		System.out.println(list.size() + ":" + list.get(0).getEname());
//
//		EmpVO vo = session.selectOne("EmpMapper.empDetailSQL", 7788);
//		System.out.println(vo.getEname());
		
		db.dbClose(session);
	}

	public void dbClose(SqlSession conn) {
		if(conn != null) {
			System.out.println("conn close");
			conn.close();
		}
	}

	//public Connection dbConn() {
	public SqlSession dbConn() {
		Reader reader = null;
		SqlSessionFactory dbFactory = null;
		SqlSession session = null;
		try {
			reader = Resources.getResourceAsReader("mybatis-context.xml");
			dbFactory = new SqlSessionFactoryBuilder().build(reader);

			if(dbFactory == null)
				System.out.println("factroy null");
			else
				System.out.println("factroy open");

			session = dbFactory.openSession();
			if(session == null)
				System.out.println("conn null");
			else
				System.out.println("conn open");

		} catch (IOException e) {
			e.printStackTrace();
		}
		return session;
	}

}
