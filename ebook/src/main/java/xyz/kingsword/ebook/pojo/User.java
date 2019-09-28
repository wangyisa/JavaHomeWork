package xyz.kingsword.ebook.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 
 */
@Data
public class User implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private Long balance;

    /**
     * 1才疏学浅2渐入佳境3博览群书4博古通今
     */
    private Integer level;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}