package xyz.kingsword.ebook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("xyz.kingsword.ebook.dao")
@SpringBootApplication
public class EBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(EBookApplication.class, args);
    }

}
