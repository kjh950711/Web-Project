package app.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


public class BeanCallTest {

	public static void main(String[] args) {
		//BeanFactory - XMLBeanFactory
		//ApplicationContext - ClassPathXmlApplicationContext
		//ApplicationContext - FileSystemXmlApplicationContext
		//WebApplicationContext - XmlWebApplicationContext
		
		String xml_file_path = "C:\\kosa\\workspace_spring\\dark_horse\\src\\main\\webapp\\WEB-INF\\servlet-context.xml";
		ApplicationContext ctx 
		= new FileSystemXmlApplicationContext(xml_file_path);
		
//		ApplicationContext ctx 
//		= new ClassPathXmlApplicationContext(xml_file_path);
		
		SqlSessionTemplate session = (SqlSessionTemplate)ctx.getBean("sqlSession"); //new EmpDAO();
		if(session == null)
			System.out.println("dbcp-mybatis session null");
		else
			System.out.println("dbcp-mybatis session ok");

		
		//------------- DBCP Conn test ------------------
		DataSource ds = (DataSource)ctx.getBean("mydbcp");
		//DataSource ds = new BasicDataSource();
		
		try {
			Connection conn = ds.getConnection();
			if(conn == null)
				System.out.println("DBCP conn faild");
			else
				System.out.println("DBCP conn ok");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
