package com.yzh.springcloud.system.core.oss;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 说明：
 *
 * @author 杨忠豪
 * @date 2019/8/18
 * @email 1659080016@qq.com
 **/
@Component
@ConfigurationProperties(prefix = "oss")
@Data
public class OssProperties {
    private String bucket;
    private String endPoint;
    private String accessKeyId;
    private String accessKeySecret;
}
