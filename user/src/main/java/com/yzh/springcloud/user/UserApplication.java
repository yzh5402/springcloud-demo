package com.yzh.springcloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 说明：
 *
 * @author 杨忠豪
 * @date 2019/8/18
 * @email 1659080016@qq.com
 **/
@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        new SpringApplication(UserApplication.class).run(args);
    }
}
