package xyz.kingsword.ebook.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author
 */
@Data
public class Book implements Serializable {
    private Integer id;

    private Integer userId;

    private Integer classifyId;

    /**
     * 全书字数
     */
    private Integer wordsNum;

    /**
     * -1删除0完本1更新中
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

}