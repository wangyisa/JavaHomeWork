package utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



/**
 * 数据库连接工具类
 * @author Sun
 *
 */
public class JdbcUtils {
	static String url = null;
	static String username = null;
	static String password = null;
	
	//加载jdbc.properties文件，加载驱动程序
	static {
		Properties pros = new Properties();
		try {
			InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
			pros.load(is);
			is.close();
			url = pros.getProperty("url");
			username = pros.getProperty("username");
			password = pros.getProperty("password");
			Class.forName(pros.getProperty("driver"));
		} catch (IOException e) {
			System.out.println("IO异常");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFound！！！");
			e.printStackTrace();
		}
		
	}
	//建立连接
	public static Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("获取连接失败");
		}
	}
	
	//关闭资源
	public static void closeRes(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
}
