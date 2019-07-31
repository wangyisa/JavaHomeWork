package dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import pojo.Fund;
import pojo.FundExample;

public interface FundMapper {
    long countByExample(FundExample example);

    int deleteByExample(FundExample example);

    int deleteByPrimaryKey(String fundId);

    int insert(Fund record);

    int insertSelective(Fund record);

    List<Fund> selectByExample(FundExample example);

    Fund selectByPrimaryKey(String fundId);

    int updateByExampleSelective(@Param("record") Fund record, @Param("example") FundExample example);

    int updateByExample(@Param("record") Fund record, @Param("example") FundExample example);

    int updateByPrimaryKeySelective(Fund record);

    int updateByPrimaryKey(Fund record);
}