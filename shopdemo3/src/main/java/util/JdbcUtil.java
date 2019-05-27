package util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://kingsword.top:3306/shopdemo?useSSL=false";
    private static final String USER = "root";
    private static final String PWD = "yunb3306mysql";


    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void close(ResultSet rs,Statement prs ,Connection conn ){
        try {
            if(rs != null){
                rs.close();
            }
            if(prs != null){
                prs.close();
            }
            if(conn != null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(JdbcUtil.getConnection());
    }
}