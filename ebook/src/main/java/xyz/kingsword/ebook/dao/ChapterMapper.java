package xyz.kingsword.ebook.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import xyz.kingsword.ebook.pojo.Chapter;

public interface ChapterMapper {

    List<Chapter> findAll();
    int deleteByPrimaryKey(Integer id);

    int insert(Chapter record);

    int insertSelective(Chapter record);

    Chapter selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Chapter record);

    int updateByPrimaryKey(Chapter record);
    int updateStatusByPrimaryKey(@Param("status")Integer status,@Param("id")Integer id);
}