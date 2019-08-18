package com.yzh.springcloud.system.core;

import java.io.File;
import java.io.InputStream;

/**
 * 说明：文件工具类
 *
 * @author 杨忠豪
 * @date 2019/8/18
 * @email 1659080016@qq.com
 **/
public interface FileUtil {

    /**
     * 上传文件
     *
     * @param fileName
     * @param inputStream
     * @return
     */
    default boolean upload(String fileName, InputStream inputStream) {
        throw new RuntimeException("文件上传失败");
    }

    /**
     * 上传文件
     *
     * @param fileName
     * @param context
     * @return
     */
    default boolean upload(String fileName, byte[] context) {
        throw new RuntimeException("文件上传失败");
    }

    /**
     * 下载文件，返回文件流
     *
     * @param fileName
     * @return
     */
    default InputStream download(String fileName) {
        throw new RuntimeException("文件下载失败");
    }

    /**
     * 下载文件到本地
     *
     * @param fileName
     * @param localFilePath
     */
    default void download(String fileName, String localFilePath) {
        throw new RuntimeException("文件下载失败");
    }

    /**
     * 文件是否存在
     *
     * @param fileName
     * @return
     */
    default boolean isExist(String fileName){
        return false;
    }
}
