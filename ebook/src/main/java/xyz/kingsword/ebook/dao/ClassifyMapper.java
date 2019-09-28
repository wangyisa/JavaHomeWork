package xyz.kingsword.ebook.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.kingsword.ebook.pojo.Classify;

public interface ClassifyMapper {


    int deleteByPrimaryKey(Integer id);

    int insert(Classify record);

    int insertSelective(Classify record);


    Classify selectByPrimaryKey(Integer id);



    int updateByPrimaryKeySelective(Classify record);

    int updateByPrimaryKey(Classify record);
}