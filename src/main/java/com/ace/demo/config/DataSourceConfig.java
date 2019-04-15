package com.ace.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig
{
    @Bean(name = "investDataSource")
    @Qualifier("investDataSource")
    @ConfigurationProperties(prefix="spring.datasource.invest")
    @Primary
    public DataSource investDataSource()
    {
        return DataSourceBuilder.create().build();
    }
    
    @Bean(name = "investJdbcTemplate")
    public JdbcTemplate investJdbcTemplate(
            @Qualifier("investDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
    
    

//    @Bean(name = "extDataSource")
//    @Qualifier("extDataSource")
//    @ConfigurationProperties(prefix="spring.datasource.ext")
//    public DataSource extDataSource()
//    {
//        return DataSourceBuilder.create().build();
//    }
//
//
//    @Bean(name = "extJdbcTemplate")
//    public JdbcTemplate extJdbcTemplate(
//            @Qualifier("extDataSource") DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
}
