package xyz.kingsword.ebook.service;

import org.springframework.stereotype.Service;
import xyz.kingsword.ebook.pojo.Book;
import xyz.kingsword.ebook.pojo.Chapter;

import java.util.List;

@Service
public interface ChapterService {
    int insert(Chapter record);
    int updateByPrimaryKey(Chapter record);
    int deleteBytatus(Integer status,Integer id);
    List<Chapter> findAll();
    Chapter selectByPrimaryKey(Integer id);
}
