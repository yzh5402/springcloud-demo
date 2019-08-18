package com.yzh.springcloud.system.core.oss;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

/**
 * 说明：
 *
 * @author 杨忠豪
 * @date 2019/8/18
 * @email 1659080016@qq.com
 **/
@Component
@Import(OssProperties.class)
public class OssHelper {

    /**
     * oss客户端
     */
    private static OSSClient ossClient;
    /**
     * oss参数
     */
    private OssProperties ossProperties;

    public OssHelper(OssProperties ossProperties) {
        this.ossProperties = ossProperties;
        init();
    }

    /**
     * 初始化
     */
    private void init() {
        ossClient = new OSSClient(ossProperties.getEndPoint(), ossProperties.getAccessKeyId(), ossProperties.getAccessKeySecret());
    }

    /**
     * 创建bucket
     *
     * @param bucketName
     * @return
     */
    public Bucket createBucket(String bucketName) {
        return ossClient.createBucket(bucketName);
    }

    /**
     * 上传Byte数组
     *
     * @param objectName
     * @param content
     * @return
     */
    public boolean putObject(String objectName, byte[] content) {
        return this.putObject(ossProperties.getBucket(), objectName, new ByteArrayInputStream(content));
    }

    /**
     * 上传Byte数组
     *
     * @param bucketName
     * @param objectName
     * @param content
     * @return
     */
    public boolean putObject(String bucketName, String objectName, byte[] content) {
        ossClient.putObject(bucketName, objectName, new ByteArrayInputStream(content));
        return isExist(bucketName, objectName);
    }

    /**
     * 上传网络流
     *
     * @param objectName
     * @param inputStream
     * @return
     */
    public boolean putObject(String objectName, InputStream inputStream) {
        return putObject(ossProperties.getBucket(), objectName, inputStream);
    }

    /**
     * 上传网络流
     *
     * @param bucketName
     * @param objectName
     * @param inputStream
     * @return
     */
    public boolean putObject(String bucketName, String objectName, InputStream inputStream) {
        ossClient.putObject(bucketName, objectName, inputStream);
        return isExist(bucketName, objectName);
    }

    /**
     * 上传文件流
     *
     * @param objectName
     * @param file
     * @return
     */
    public boolean putObject(String objectName, File file) {
        return putObject(ossProperties.getBucket(), objectName, file);
    }

    /**
     * 上传文件流
     *
     * @param bucketName
     * @param objectName
     * @param file
     * @return
     */
    public boolean putObject(String bucketName, String objectName, File file) {
        ossClient.putObject(bucketName, objectName, file);
        return isExist(bucketName, objectName);
    }

    /**
     * 文件下载，返回文件流
     *
     * @param objectName
     * @return
     */
    public InputStream getObject(String objectName) {
        return this.getObject(ossProperties.getBucket(), objectName);
    }

    /**
     * 文件下载，返回文件流
     *
     * @param bucketName
     * @param objectName
     * @return
     */
    public InputStream getObject(String bucketName, String objectName) {
        OSSObject object = ossClient.getObject(bucketName, objectName);
        return object != null ? object.getObjectContent() : null;
    }

    /**
     * 下载到本地文件
     *
     * @param objectName
     * @param localFilePath
     */
    public void getObjectToLocal(String objectName, String localFilePath) {
        this.getObject(ossProperties.getBucket(), objectName, localFilePath);
    }

    /**
     * 下载到本地文件
     *
     * @param bucketName
     * @param objectName
     * @param localFilePath
     */
    public void getObject(String bucketName, String objectName, String localFilePath) {
        ossClient.getObject(new GetObjectRequest(bucketName, objectName), new File(localFilePath));
    }

    /**
     * 文件是否存在
     *
     * @param objectName
     * @return
     */
    public boolean isExist(String objectName) {
        return this.isExist(ossProperties.getBucket(), objectName);
    }

    /**
     * 文件是否存在
     *
     * @param bucketName
     * @param objectName
     * @return
     */
    public boolean isExist(String bucketName, String objectName) {
        return ossClient.doesObjectExist(bucketName, objectName);
    }

    /**
     * 关闭OSSClient
     */
    public void shutdown() {
        ossClient.shutdown();
    }

    /**
     * 销毁方法
     */
    @PreDestroy
    public void destory() {
        shutdown();
    }
}
