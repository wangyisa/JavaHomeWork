package dao.user.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.user.user_selfinfo;
import entitys.User;
import utils.JdbcUtils;

public class user_selfinfo_Impl implements user_selfinfo{
	Connection conn = null;
	ResultSet rs = null;
	PreparedStatement ps = null;
	@Override
	public void selfinfoinsert(int id, String school, String profession, String stringskills) {
		User user = null;
		int rows = 0;
		//建立连接
		try {
			conn = JdbcUtils.getConnection();
		} catch (SQLException e) {
			System.out.println("数据库连接失败");
			e.printStackTrace();
		}
		//创建SQL语句
		String sql = "update user set school = ?,profession = ?,skill = ? where id = ?";
		//执行SQL语句
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, school);
			ps.setString(2, profession);
			ps.setString(3, stringskills);
			ps.setInt(4, id);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeRes(conn, ps, rs);
		}
		
		
	}
	
	

}
