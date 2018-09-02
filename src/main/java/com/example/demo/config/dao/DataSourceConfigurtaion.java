package com.example.demo.config.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyVetoException;

/**
 * Created by lsl on 2018/9/1.
 */
@Configuration
//配置mybatis mapper的扫描路径
@MapperScan("com.example.demo.dao")
public class DataSourceConfigurtaion {
    @Value("${jdbc.driver}")
    private String jdbcDrive;
    @Value("${jdbc.url}")
    private String jdbcUrl;
    @Value("${jdbc.username}")
    private String jdbcUserName;
    @Value("${jdbc.passsowrd}")
    private String jdbcPassword;


    @Bean(name="dataSource")
    public ComboPooledDataSource createDataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(jdbcDrive);
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(jdbcUserName);
        dataSource.setPassword(jdbcPassword);

        //链接后不自动commit
        dataSource.setAutoCommitOnClose(false);

        return dataSource;
    }
}
