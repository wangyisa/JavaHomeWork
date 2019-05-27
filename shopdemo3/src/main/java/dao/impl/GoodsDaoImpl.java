package dao.impl;

import dao.GoodsDao;
import model.Goods;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {

    @Override
    public List<Goods> findAll() {
        List<Goods> list = new ArrayList<Goods>();
        Connection connection= JdbcUtil.getConnection();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from goods");
            ResultSet resultSet=preparedStatement.executeQuery();
            while(resultSet.next())
            {
                Goods goods=new Goods();
                goods.setId(resultSet.getInt(1));
                goods.setTitle(resultSet.getString(2));
               // goods.setPhoto(resultSet.getString(3));
                goods.setDescription(resultSet.getString(4));
                goods.setType(resultSet.getString(5));
                goods.setPrice(resultSet.getFloat(6));
                goods.setNumber(resultSet.getInt(7));
                list.add(goods);

            }
            JdbcUtil.close(resultSet,preparedStatement,connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
