package com.yunst.configure;

import com.allinpay.yunst.sdk.YunClient;
import com.allinpay.yunst.sdk.bean.YunConfig;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author dudangman
 */
@Configuration
public class YunstConfigure {

    @PostConstruct
    public void yunClient(YunstProperties properties){
        YunConfig yunConfig = new YunConfig();
        yunConfig.setServerUrl(properties.getServerUrl());
        yunConfig.setPwd(properties.getPwd());
        yunConfig.setPath(properties.getPath());
        yunConfig.setAlias(properties.getAlias());
        yunConfig.setSysId(properties.getSysId());
        yunConfig.setTlCertPath(properties.getTlCertPath());
        yunConfig.setVersion(properties.getVersion());
        YunClient.configure(yunConfig);
    }
}
