package com.yunst.configure;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 通联配置信息
 * @author dudangman
 */
@Configuration
@Data
public class YunstProperties {
    @Value("${yunst.serverUrl}")
    private String serverUrl;

    @Value("${yunst.sysId}")
    private String sysId;

    @Value("${yunst.pwd}")
    private String pwd;

    @Value("${yunst.alias}")
    private String alias;

    @Value("${yunst.path}")
    private String path;

    @Value("${yunst.version}")
    private String version;

    @Value("${yunst.tlCertPath}")
    private String tlCertPath;

}
