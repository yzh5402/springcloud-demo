package com.yzh.springcloud.system.core;

import com.yzh.springcloud.core.helper.SpringContextHelper;
import com.yzh.springcloud.system.core.oss.OssHelper;

import java.io.InputStream;

/**
 * 说明：
 *
 * @author 杨忠豪
 * @date 2019/8/18
 * @email 1659080016@qq.com
 **/
public class OssFileUtil implements FileUtil {

    private OssHelper ossHelper;

    public OssFileUtil() {
        this.ossHelper = SpringContextHelper.getBean(OssHelper.class);
    }

    @Override
    public boolean upload(String fileName, InputStream inputStream) {
        return ossHelper.putObject(fileName, inputStream);
    }

    @Override
    public boolean upload(String fileName, byte[] context) {
        return ossHelper.putObject(fileName, context);
    }

    @Override
    public InputStream download(String fileName) {
        return ossHelper.getObject(fileName);
    }

    @Override
    public void download(String fileName, String localFilePath) {
        ossHelper.getObjectToLocal(fileName, localFilePath);
    }

    @Override
    public boolean isExist(String fileName) {
        return ossHelper.isExist(fileName);
    }
}
