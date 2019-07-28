///**
//* @Title: SimpleRestClient.java
//* @Package com.fpq.config
//* @Description: TODO(用一句话描述该文件做什么)
//* @author slx
//* @date 2019年3月25日
//* @version V1.0
//*/
//package com.fpq.config;
//
//import org.springframework.context.annotation.Lazy;
//import org.springframework.http.client.SimpleClientHttpRequestFactory;
//import org.springframework.http.converter.FormHttpMessageConverter;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.StringHttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.DefaultResponseErrorHandler;
//import org.springframework.web.client.RestTemplate;
// 
//import javax.annotation.PostConstruct;
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.List;
//
///**
//* @classDesc: 功能描述：
//* @author 付品欣
//* @createTime 2019年3月25日 下午11:00:32
//* @version: V1.0
//* @copyright:深圳科翔教育科技有限公司
//* @wechat:qhjx666888
//*/
//@Component
//@Lazy(false)
//public class SimpleRestClient {
//
//	private static RestTemplate restTemplate;
//	 
//    static {
//        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
//        requestFactory.setReadTimeout(5000);
//        requestFactory.setConnectTimeout(5000);
// 
//        // 添加转换器
//        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
//        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
//        messageConverters.add(new FormHttpMessageConverter());
//        messageConverters.add(new MappingJackson2XmlHttpMessageConverter());
//        messageConverters.add(new MappingJackson2HttpMessageConverter());
// 
//        restTemplate = new RestTemplate(messageConverters);
//        restTemplate.setRequestFactory(requestFactory);
//        restTemplate.setErrorHandler(new DefaultResponseErrorHandler());
// 
//        System.out.println("SimpleRestClient初始化完成");
//    }
// 
//    private SimpleRestClient() {
// 
//    }
// 
//    @PostConstruct
//    public static RestTemplate getClient() {
//        return restTemplate;
//    }
//}
