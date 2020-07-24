package com.sunny.demo.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfig {

	// pooling기술 (원래대로라면 rs를 받아서 일일이 오브젝트를 만들어줘야함)
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource(){
    	return DataSourceBuilder.create().build();
	}
}