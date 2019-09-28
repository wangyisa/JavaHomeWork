package xyz.kingsword.ebook.service;

import org.springframework.stereotype.Service;
import xyz.kingsword.ebook.pojo.Book;

import java.util.List;

@Service
public interface BookService {
    int insert(Book record);
    int updateByPrimaryKey(Book record);
    int deleteBytatus(Integer status,Integer id);
    List<Book> findAll();
    Book selectByPrimaryKey(Integer id);
}
