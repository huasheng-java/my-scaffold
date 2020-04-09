package com.my.scaffold.config;

import com.my.scaffold.interceptor.BaseInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

/**
 * **************************************************************
 * 公司名称    :杭州巨星科技股份有限公司
 * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
 * 类 名 称    :
 * 功能描述    : WebMvc配置
 * 业务描述    :
 * 作 者 名    :@Author Royal(wls)
 * 开发日期    :2019/1/15 9:46
 * Created     :IntelliJ IDEA
 * **************************************************************
 * 修改日期    :
 * 修 改 者    :
 * 修改内容    :
 * **************************************************************
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private BaseInterceptor baseInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(baseInterceptor);
    }

    @Bean
    public HttpMessageConverter<String> responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBodyConverter());
    }
    /**
     * 重写：加载静态资源
     * 自定义配置静态资源路径：
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html") .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars*//**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new MyHandlerInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login","/login/main","/logout","/genCaptcha","/static/**","/showBlog/**");
//        registry.addInterceptor(new BlogHandlerInterceptor())
//                .addPathPatterns("/showBlog/**");
//    }
}
