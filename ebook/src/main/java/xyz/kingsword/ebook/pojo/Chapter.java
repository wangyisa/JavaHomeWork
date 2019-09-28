package xyz.kingsword.ebook.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
@Data
public class Chapter implements Serializable {
    private Integer id;

    private Integer fileId;

    private Integer bookId;

    private Date createTime;

    /**
     * -1删除0发布1编写中
     */
    private Integer status;

    /**
     * 章节字数
     */
    private Integer wordsNum;

    private static final long serialVersionUID = 1L;

}