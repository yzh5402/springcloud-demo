package com.yzh.springcloud.system.core.factory;

import com.yzh.springcloud.system.core.FileUtil;
import com.yzh.springcloud.system.core.OssFileUtil;

/**
 * 说明：oss文件工厂类
 *
 * @author 杨忠豪
 * @date 2019/8/18
 * @email 1659080016@qq.com
 **/
public class OssFileFactory {

    private OssFileFactory(){}

    private static class OssFileFactoryHolder{
        private static final OssFileUtil INSTANCE = new OssFileUtil();
    }

    public static FileUtil getFileUtil(){
        return OssFileFactoryHolder.INSTANCE;
    }
}
