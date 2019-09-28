package xyz.kingsword.ebook.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.kingsword.ebook.pojo.ReadRecord;

public interface ReadRecordMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ReadRecord record);

    int insertSelective(ReadRecord record);


    ReadRecord selectByPrimaryKey(Integer id);



    int updateByPrimaryKeySelective(ReadRecord record);

    int updateByPrimaryKey(ReadRecord record);
}