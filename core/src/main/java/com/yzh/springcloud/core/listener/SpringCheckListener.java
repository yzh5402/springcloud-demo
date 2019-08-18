package com.yzh.springcloud.core.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * 说明：spring监听器
 *
 * @author 杨忠豪
 * @date 2019/8/18
 * @email 1659080016@qq.com
 **/
@Component
public class SpringCheckListener implements ApplicationListener<ApplicationEvent> {
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if(event instanceof ContextClosedEvent){
            System.out.println(event.getClass().getSimpleName()+" 事件已发生！");
        }else if(event instanceof ContextRefreshedEvent){
            System.out.println(event.getClass().getSimpleName()+" 事件已发生！");
        }else if(event instanceof ContextStartedEvent){
            System.out.println(event.getClass().getSimpleName()+" 事件已发生！");
        }else if(event instanceof ContextStoppedEvent){
            System.out.println(event.getClass().getSimpleName()+" 事件已发生！");
        }else{
            System.out.println("有其它事件发生:"+event.getClass().getName());
        }
    }
}
