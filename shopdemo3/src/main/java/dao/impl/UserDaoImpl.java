package dao.impl;


import dao.UserDao;
import model.User;
import util.JdbcUtil;

import java.sql.*;


public class UserDaoImpl implements UserDao {
    @Override
    public String FindPasswordByUsername(String username) {

        String password = null;
        System.out.println(username);
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "select password  from user where username='" + username + "'";
        try {
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {

                password = resultSet.getString("password");
                System.out.println(password);

            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JdbcUtil.close(resultSet, statement, connection);

        }
        return password;
    }

    @Override
    public void insertUser(User user) {
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        try {
            String sql = "insert into user(username,password) values(?,?)";
            connection = JdbcUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getUsername());
            statement.setString(2,user.getPassword());
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(resultSet, statement, connection);
        }


    }

    @Override
    public void updateUser(User user) {
    Connection connection=null;
    ResultSet resultSet=null;
    PreparedStatement preparedStatement=null;
    try {
        connection=JdbcUtil.getConnection();
        preparedStatement=connection.prepareStatement("update user set gender = ?,age = ?,email = ?,graduateSchool = ?,tel = ?,address = ?,highestEducation = ?,major = ? where username = ?");
        preparedStatement.setString(1,user.getGender());
        preparedStatement.setInt(2,user.getAge());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setString(4,user.getGraduateSchool());
        preparedStatement.setString(5,user.getTel());
        preparedStatement.setString(6,user.getAddress());
        preparedStatement.setString(7,user.getHighestEducation());
        preparedStatement.setString(8,user.getMajor());
        preparedStatement.setString(9,user.getUsername());
        preparedStatement.executeUpdate();
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    finally {
        JdbcUtil.close(resultSet,preparedStatement,connection);
    }
    }

    @Override
    public User selectUserByUsername(String username) {
        Connection connection=JdbcUtil.getConnection();
        User user=new User();
        try{
            PreparedStatement preparedStatement=connection.prepareStatement("select * from user where username = ?");
            preparedStatement.setString(1,username);
            ResultSet resultSet=preparedStatement.executeQuery();
            if(resultSet.next())
            {

                user.setGender(resultSet.getString(4));
                user.setAge(resultSet.getInt(5));
                user.setEmail(resultSet.getString(6));
                user.setGraduateSchool(resultSet.getString(7));
                user.setTel(resultSet.getString(8));
                user.setAddress(resultSet.getString(9));
                user.setHighestEducation(resultSet.getString(10));
                user.setMajor(resultSet.getString(11));
            }
            JdbcUtil.close(resultSet,preparedStatement,connection);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        return user;
    }

    public static void main(String[] args) {
       /*User user=new User();
       UserDaoImpl userDao=new UserDaoImpl();
       user.setUsername("demo1");
       user.setEmail("233");
       user.setTel("123345");
       user.setGender("1");
       userDao.updateUser(user);*/
    }


}
