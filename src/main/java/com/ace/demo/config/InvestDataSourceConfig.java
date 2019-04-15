package com.ace.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateSettings;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef="entityManagerFactoryInvest",
        transactionManagerRef="transactionManagerInvest",
        basePackages= { "com.ace.demo.repository" }) //设置Repository所在位置
public class InvestDataSourceConfig
{
    @Autowired
    @Qualifier("investDataSource")
    private DataSource investDataSource;

    @Primary
    @Bean(name = "entityManagerInvest")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryInvest(builder).getObject().createEntityManager();
    }

    @Primary
    @Bean(name = "entityManagerFactoryInvest")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryInvest (EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(investDataSource)
                .properties(getVendorProperties(investDataSource))
                .packages("com.ace.demo.model") //设置实体类所在位置
                .persistenceUnit("investPersistenceUnit")
                .build();
    }

    @Autowired
    private JpaProperties jpaProperties;

    private Map<String, Object> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(new HibernateSettings());
    }

    @Primary
    @Bean(name = "transactionManagerInvest")
    public PlatformTransactionManager transactionManagerInvest(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryInvest(builder).getObject());
    }
}
