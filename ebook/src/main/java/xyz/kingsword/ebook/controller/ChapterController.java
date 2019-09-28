package xyz.kingsword.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.kingsword.ebook.pojo.Chapter;
import xyz.kingsword.ebook.pojo.Result;
import xyz.kingsword.ebook.service.ChapterService;

@RequestMapping
@RestController
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping(value="/insertChapter",method = RequestMethod.POST)
    public Object insert(@RequestBody Chapter chapter){
        chapterService.insert(chapter);
        return new Result<>();
    }
    @RequestMapping(value="updateChapter",method = RequestMethod.POST)
    public Object update(@RequestBody Chapter chapter){
        chapterService.updateByPrimaryKey(chapter);
        return new Result<>();
    }
    @RequestMapping(value="deleteChapter",method= RequestMethod.POST)
    public Object deleteById(Integer id){
        chapterService.deleteBytatus(-1,id);
        return new Result<>();
    }
    @RequestMapping(value = "findAllChapter",method = RequestMethod.POST)
    public Object findAll(){
        Result result=new Result(chapterService.findAll());
        return result;
    }
    @RequestMapping(value = "selectChapterById",method = RequestMethod.POST)
    public Object selectById(int Id){
        chapterService.selectByPrimaryKey(Id);
        return new Result<>();

    }
}
