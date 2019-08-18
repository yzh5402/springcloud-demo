package com.yzh.springcloud.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 说明：测试
 *
 * @author 杨忠豪
 * @date 2019/8/18
 * @email 1659080016@qq.com
 **/
@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(TestApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
