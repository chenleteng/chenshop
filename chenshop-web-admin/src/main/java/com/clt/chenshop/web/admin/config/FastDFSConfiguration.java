package com.clt.chenshop.web.admin.config;

import com.clt.chenshop.common.utils.StorageFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FastDFSConfiguration {
    @Bean
    public StorageFactory storageFactory(){
        return new StorageFactory();
    }

}
