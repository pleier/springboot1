//package com.plei.springboot.druid;
//
//
//import javax.sql.DataSource;
//
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.alibaba.druid.support.http.StatViewServlet;
//import com.alibaba.druid.support.http.WebStatFilter;
//import org.springframework.context.annotation.Primary;
//
///**
// * 配置druid数据源
// *
// */
//@Configuration
//public class DruidConfiguration {
//
//    private Logger logger = LoggerFactory.getLogger(DruidConfiguration.class);
//
//    @Bean
//    public ServletRegistrationBean druidStatViewServlet() {
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        registrationBean.addInitParameter("allow", "127.0.0.1");
//        registrationBean.addInitParameter("deny", "192.168.31.234");
//        registrationBean.addInitParameter("loginUsername", "admin");
//        registrationBean.addInitParameter("loginPassword", "123456");
//        registrationBean.addInitParameter("resetEnable", "false");
//
//        return registrationBean;
//    }
//
//    @Bean
//    public FilterRegistrationBean druidWebStatViewFilter() {
//        FilterRegistrationBean registrationBean = new FilterRegistrationBean(new WebStatFilter());
//        registrationBean.addInitParameter("urlPatterns", "/*");
//        registrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
//
//        return registrationBean;
//
//    }
//
//
//    @Bean
//    @Primary
//    public DataSource druidDataSource(){
//        return DruidDataSourceBuilder.create().build();
//    }
//}