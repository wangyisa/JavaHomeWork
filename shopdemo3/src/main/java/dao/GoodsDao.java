package dao;

import model.Goods;

import java.util.List;

public interface GoodsDao {
    public List<Goods> findAll();
}
