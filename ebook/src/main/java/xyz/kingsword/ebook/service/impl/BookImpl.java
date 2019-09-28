package xyz.kingsword.ebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.kingsword.ebook.dao.BookMapper;
import xyz.kingsword.ebook.pojo.Book;
import xyz.kingsword.ebook.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;
    @Override
    public int insert(Book record) {

        return bookMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Book record) {
        return bookMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteBytatus(Integer status,Integer id) {

        return bookMapper.updateStatusByPrimaryKey(status,id);
    }

    @Override
    public List<Book> findAll() {
        List<Book> list=bookMapper.findAll();
        List<Book> list1=new ArrayList<>();
        for(Book book:list){
            if (book.getStatus()!=-1){
                list1.add(book);
            }
        }
        return list1;
    }

    @Override
    public Book selectByPrimaryKey(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }
}
