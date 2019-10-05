package com.wangyanba.article;/**
 * Created by ASUS on 2019/10/4.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
*   @author   王彦宝
*   @description 文章启动类
*   @date 2019/10/417:07
*/
@SpringBootApplication
@MapperScan("")
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
