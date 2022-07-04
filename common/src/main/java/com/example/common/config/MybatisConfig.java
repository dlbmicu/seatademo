package com.example.common.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author zhouhao
 * @date 2022/7/4
 */
@Configuration
public class MybatisConfig {
    @Bean
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource firstDataSource(){

        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.second")
    public DataSource secondDataSource(){

        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public DataSource dataSource(DataSource firstDataSource, DataSource secondDataSource) {
        HashMap<Object, Object> targetDataSources = new HashMap<>(5);
        targetDataSources.put(DynamicDataSource.FIRST, firstDataSource);
        targetDataSources.put(DynamicDataSource.SECOND, secondDataSource);
        return new DynamicDataSource(firstDataSource, targetDataSources);
    }


}
