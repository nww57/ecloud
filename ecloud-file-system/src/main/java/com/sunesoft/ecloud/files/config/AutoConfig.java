//package com.sunesoft.ecloud.files.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//
///**
// * @author: Zhouzh
// * @Date: 2018/4/16
// */
//@Configuration
//public class AutoConfig {
//
//    @Bean(name="multipartResolver")
//    public CommonsMultipartResolver getCommonsMultipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(20971520);
//        multipartResolver.setMaxInMemorySize(1048576);
//        return multipartResolver;
//    }
//}
