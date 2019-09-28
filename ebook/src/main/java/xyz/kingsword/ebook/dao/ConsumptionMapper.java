package xyz.kingsword.ebook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import xyz.kingsword.ebook.pojo.Consumption;

public interface ConsumptionMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Consumption record);

    int insertSelective(Consumption record);


    Consumption selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Consumption record);

    int updateByPrimaryKey(Consumption record);
}