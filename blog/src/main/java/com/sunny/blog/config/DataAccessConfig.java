package com.sunny.blog.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(basePackages = "com.sunny.blog.repository") // 여기 걸어놔야 자동으로 읽힘
public class DataAccessConfig {

    @Bean // 리턴값을 IoC로 등록해줌, 스프링 컨텍스트에 담아줌 = Bean은 인스턴스 오브젝트
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        // SQLSession(SQLSessionFactory를 통해서 만들어짐, 어떤 데이터 소스를 쓸지, MyBatis 또는 JPA를 쓸지결정)
        // -> DataSource(MyBatis역할) -> DB(MySQL)
        // Controller -> repository -> SQLSession -> DataSource -> DB
        // Controller와 repository와 연결되어 있음
        // maaper파일은 repository와 연결되어 있음
        // SQLSession은 CRUD 함수를 가지고 있음
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(
        		new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return sessionFactory.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}