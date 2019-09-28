package xyz.kingsword.ebook.dao;


import org.apache.ibatis.annotations.Param;
import xyz.kingsword.ebook.pojo.Book;

import java.util.List;

public interface BookMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Book record);

    int insertSelective(Book record);


    Book selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Book record);
    int updateStatusByPrimaryKey(@Param("status")Integer status,@Param("id")Integer id);
    int updateByPrimaryKey(Book record);
    List<Book> findAll();
}