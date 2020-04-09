//package com.my.scaffold.config;
//
//import freemarker.template.Configuration;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
//
///**
// * Created by wangl on 2017/11/26.
// * todo:
// */
//@Component
//public class FreemarkerConfig {
//
//    @Autowired
//    private Configuration configuration;
//
////    @Autowired
////    private SystemDirective systemDirective;
////
////    @Autowired
////    private SysUserTempletModel sysUserTempletModel;
////
////    @PostConstruct
////    public void setSharedVariable() {
////        //系统字典标签
////        configuration.setSharedVariable("my",systemDirective);
////        //获取系统用户信息
////        configuration.setSharedVariable("sysuser",sysUserTempletModel);
////    }
//
//    @Bean
//    public ViewResolver viewResolverFtl() {
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setCache(false);
//        resolver.setViewClass(org.springframework.web.servlet.view.freemarker.FreeMarkerView.class);
//        resolver.setRequestContextAttribute("re");
//        resolver.setExposeRequestAttributes(true);
//        resolver.setExposeSessionAttributes(true);
//        resolver.setSuffix(".ftl");
//        resolver.setContentType("text/html;charset=UTF-8");
//        resolver.setOrder(0);
//        return resolver;
//    }
//
//    @Bean
//    public ViewResolver viewResolverHtml() {
//        FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
//        resolver.setCache(false);
//        resolver.setViewClass(org.springframework.web.servlet.view.freemarker.FreeMarkerView.class);
//        resolver.setRequestContextAttribute("re");
//        resolver.setExposeRequestAttributes(true);
//        resolver.setExposeSessionAttributes(true);
//        resolver.setOrder(1);
//        resolver.setSuffix(".html");
//        resolver.setContentType("text/html;charset=UTF-8");
//        return resolver;
//    }
//
//}
