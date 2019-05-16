package dao.user.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.user.user_login;
import entitys.User;
import utils.JdbcUtils;

public class user_login_Impl implements user_login {
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;

	@Override
	public User login(String name,String password) {
		User user = null;
		//建立连接
		try {
			conn = JdbcUtils.getConnection();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		//创建SQL语句
		String sql = "select * from user where name = ? and password = ?";
		//执行SQL语句
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName(name);
				user.setPassword(password);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//关闭资源
			JdbcUtils.closeRes(conn, ps, rs);
		}
		return user;
	}



}
