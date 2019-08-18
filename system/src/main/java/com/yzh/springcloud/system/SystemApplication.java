package com.yzh.springcloud.system;

import com.yzh.springcloud.system.support.SystemBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 说明：系统启动类
 *
 * @author 杨忠豪
 * @date 2019/8/18
 * @email 1659080016@qq.com
 **/
@SpringBootApplication
@ComponentScan({"com.yzh.springcloud"})
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SystemApplication.class);
        springApplication.setBanner(new SystemBanner());
        springApplication.run(args);
    }
}
