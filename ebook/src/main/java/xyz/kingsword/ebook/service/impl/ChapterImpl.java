package xyz.kingsword.ebook.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.kingsword.ebook.dao.ChapterMapper;
import xyz.kingsword.ebook.pojo.Chapter;
import xyz.kingsword.ebook.service.ChapterService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChapterImpl implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;
    @Override
    public int insert(Chapter record) {
        return chapterMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(Chapter record) {
       return chapterMapper.updateByPrimaryKey(record);
    }

    @Override
    public int deleteBytatus(Integer status, Integer id) {
        return chapterMapper.updateStatusByPrimaryKey(status,id);
    }

    @Override
    public List<Chapter> findAll() {
        List<Chapter> list=chapterMapper.findAll();
        List<Chapter> list1=new ArrayList<>();
        for(Chapter chapter:list){
            if(chapter.getStatus()!=-1){
                list1.add(chapter);
            }
        }
        return list1;
    }

    @Override
    public Chapter selectByPrimaryKey(Integer id) {
        return chapterMapper.selectByPrimaryKey(id);
    }
}
