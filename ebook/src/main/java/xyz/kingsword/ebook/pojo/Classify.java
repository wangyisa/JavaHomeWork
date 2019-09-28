package xyz.kingsword.ebook.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 
 */
@Data
public class Classify implements Serializable {
    private Integer id;

    private Integer bookNum;

    private String keyWords;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBookNum() {
        return bookNum;
    }

    public void setBookNum(Integer bookNum) {
        this.bookNum = bookNum;
    }

    public String getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
}