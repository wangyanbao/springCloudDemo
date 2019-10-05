package com.wangyanbao.recruit;/**
 * Created by ASUS on 2019/10/4.
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import util.IdWorker;

/**
*   @author   王彦宝
*   @description 招聘启动类
*   @date 2019/10/416:19
*/
@SpringBootApplication
@MapperScan("com.wangyanbao.recruit.mapper")
public class RecruitApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecruitApplication.class,args);
    }

    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }
}
