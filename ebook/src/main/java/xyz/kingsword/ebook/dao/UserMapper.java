package xyz.kingsword.ebook.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import xyz.kingsword.ebook.pojo.User;

public interface UserMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);


    User selectByPrimaryKey(Integer id);



    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}