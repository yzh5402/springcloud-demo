package com.yzh.springcloud.core.listener;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 说明：spring启动后执行方法
 *
 * @author 杨忠豪
 * @date 2019/8/18
 * @email 1659080016@qq.com
 **/
@Component
public class SpringStarterListener implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("spring启动后执行方法。。。");
    }
}
