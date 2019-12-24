package mybaits;

import java.io.*;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import mybaits.entity.Orders;
import mybaits.entity.UacUser;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import mybaits.entity.User;
import mybaits.mappers.userDao;
import sun.misc.ProxyGenerator;

public class mybaitsTest {

	public static final Properties properties = new Properties();
	static{
		properties.setProperty("username", "root");
		properties.setProperty("password", "123456");
		properties.setProperty("url", "jdbc:mysql://127.0.0.1:3306/veuam_uac?useSSL=false&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull");
		properties.setProperty("driver", "com.mysql.jdbc.Driver");
	}
	
	public static void main(String[] args) throws Exception{

		File file = new File("src/main/resources/mybaits-config");
		InputStream in = new FileInputStream(file);
		/*PooledDataSourceFactory pooledDataSourceFactory = new PooledDataSourceFactory();
		pooledDataSourceFactory.setProperties(properties);
		DataSource dataSource = pooledDataSourceFactory.getDataSource();
		JdbcTransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration =  new Configuration(environment);
		configuration.addMapper(userDao.class);
		configuration.addLoadedResource("mapper/userDao.xml");*/
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		userDao user = sqlSession.getMapper(userDao.class);
		UacUser uacUser = user.findByLoginName("wcy");
		System.out.println(uacUser);
	//	generateClassFile(user.getClass(),"UserDaoProxy");
		//List<Orders> list = user.findOrdersByLazyLoad();
		//for (Orders order:list) {
			//System.out.println(order);
			//System.out.println(order.getUser());
		//}
		sqlSession.close();

	}


	public static void generateClassFile(Class c,String name){
		byte[] classArry = ProxyGenerator.generateProxyClass(name,c.getInterfaces());

		FileOutputStream out = null;

		try {
			out = new FileOutputStream("W:\\"+name+".class");
			out.write(classArry);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
