package com.yzh.springcloud.system;

import com.yzh.springcloud.system.core.factory.OssFileFactory;
import com.yzh.springcloud.system.core.oss.OssHelper;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 说明：
 *
 * @author 杨忠豪
 * @date 2019/8/18
 * @email 1659080016@qq.com
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FileTest {

    @Autowired
    private OssHelper ossHelper;

    @Test
    public void test01() {
        System.out.println(OssFileFactory.getFileUtil().isExist("yzh.txt"));
    }
}
