//package com.my.scaffold.config;
//
//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//
//import javax.sql.DataSource;
//import java.sql.SQLException;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * **************************************************************
// * 公司名称    :杭州巨星科技股份有限公司
// * 系统名称    :土猫网电商平台b端-Mybatis+mysql 最新架构版 v7.20
// * 类 名 称    :
// * 功能描述    : 自定义数据源加载
// * 业务描述    :
// * 作 者 名    :@Author Royal(wls)
// * 开发日期    :2019/1/11 16:32
// * Created     :IntelliJ IDEA
// * **************************************************************
// * 修改日期    :
// * 修 改 者    :
// * 修改内容    :
// * **************************************************************
// */
//@Configuration
//@Slf4j
//public class DruidConfig {
//
//    @Value("${mysql.datasource.url}")
//    private String url;
//
//    @Value("${mysql.datasource.username}")
//    private String username;
//
//    @Value("${mysql.datasource.password}")
//    private String password;
//
//    @Value("${mysql.datasource.driver-class-name}")
//    private String driverClassName;
//
//    @Value("${mysql.datasource.filters}")
//    private String filters;
//
//    @Value("${mysql.datasource.initialSize}")
//    private int initialSize;
//
//    @Value("${mysql.datasource.minIdle}")
//    private int minIdle;
//
//    /**
//     * 配置数据源：因配置了数据源监控，在springboot启动时就创建并初始化一个数据源
//     */
//    @Bean(initMethod = "init")
//    @Primary
//    public DruidDataSource myScaffoldSource(){
//        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setUrl(url);
//        dataSource.setUsername(username);
//        dataSource.setPassword(password);
//        dataSource.setDriverClassName(driverClassName);
//        dataSource.setInitialSize(initialSize);
//        dataSource.setMinIdle(minIdle);
//        dataSource.setValidationQuery("select 'x'");
//        dataSource.setTestWhileIdle(true);
//        dataSource.setTestOnBorrow(false);
//        dataSource.setTestOnReturn(false);
//        try {
//            dataSource.setFilters(filters);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            log.error("数据源款记录你失败："+e.toString());
//        }
//        return dataSource;
//    }
//
//    /**
//     * 注册Servlet信息，配置监控视图
//     * @return
//     */
//    @Bean
//    public ServletRegistrationBean druidServlet(){
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet());
//
//        //IP白名单：
////        servletRegistrationBean.addInitParameter("allow","192.168.2.21");
//        //IP黑名单 (存在共同时，deny优先于allow) :
//        // 如果满足deny的话提示:Sorry, you are not permitted to view this page.
////        servletRegistrationBean.addInitParameter("deny","192.168.6.73");
//        // 登录查看信息的账号密码, 用于登录Druid监控后台
//        servletRegistrationBean.addUrlMappings("/druid/*");
//        Map<String, String> initParameters = new HashMap<String, String>();
//        //是否能够重置数据.
//        initParameters.put("resetEnable", "true");
//        //IP白名单：allow
//        initParameters.put("allow", "");
//        //IP黑名单 (存在共同时，deny优先于allow) :
//        servletRegistrationBean.setInitParameters(initParameters);
//        return servletRegistrationBean;
//    }
//    @Bean
//    public DruidStatInterceptor getDruidStatInterceptor() {
//        return new DruidStatInterceptor();
//    }
//    /**
//     * 注册Filter信息，监控连接器
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*,*.html");
//        filterRegistrationBean.addInitParameter("profileEnable", "true");
//        filterRegistrationBean.addInitParameter("principalCookieName","USER_COOKIE");
//        filterRegistrationBean.addInitParameter("principalSessionName","");
//        filterRegistrationBean.addUrlPatterns("/*");
//        return filterRegistrationBean;
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
