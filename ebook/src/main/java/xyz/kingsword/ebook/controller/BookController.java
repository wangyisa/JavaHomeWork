package xyz.kingsword.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.kingsword.ebook.pojo.Book;
import xyz.kingsword.ebook.pojo.Result;
import xyz.kingsword.ebook.service.BookService;

@RequestMapping("/")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @RequestMapping(value="/insertBook",method = RequestMethod.POST)
    public Object insert(@RequestBody Book book){
      bookService.insert(book);
      return new Result<>();
    }
    @RequestMapping(value="updateBook",method = RequestMethod.POST)
    public Object update(@RequestBody Book book){
        bookService.updateByPrimaryKey(book);
        return new Result<>();
    }
    @RequestMapping(value="deleteBook",method= RequestMethod.POST)
    public Object deleteById(Integer id){
        bookService.deleteBytatus(-1,id);
        return new Result<>();
    }
    @RequestMapping(value = "findAllBook",method = RequestMethod.POST)
    public Object findAll(){
        Result result=new Result(bookService.findAll());
        return result;
    }
    @RequestMapping(value = "selectBookById",method = RequestMethod.POST)
    public Object selectById(int bookId){
       bookService.selectByPrimaryKey(bookId);
        return new Result<>();

    }

}
