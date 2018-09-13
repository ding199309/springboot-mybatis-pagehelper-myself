package com.dfz.springboot.druid;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySources;

import com.alibaba.druid.pool.DruidDataSource;

/** 
* @author   dfz
* 作者 E-mail:  dfz@jkinvest.cn
* @date 创建时间：2017年4月28日 下午6:04:59 
* @version 1.0 
* @parameter  
* @since  
* @return  
*/


@Configuration
public class DruidConfig {

	@Value("${share.datasource.url}")
    private String url;

    @Value("${share.datasource.username}")
    private String username;

    @Value("${share.datasource.password}")
    private String password;

    @Value("${share.datasource.driverClassName}")
    private String driverClassName;
    
    @Value("${share.datasource.initialSize}")
    private int initialSize;

    @Value("${share.datasource.minIdle}")
    private int minIdle;

    @Value("${share.datasource.maxActive}")
    private int maxActive;

    @Value("${share.datasource.maxWait}")
    private int maxWait;

    @Value("${share.datasource.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;

    @Value("${share.datasource.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;

    @Value("${share.datasource.validationQuery}")
    private String validationQuery;

    @Value("${share.datasource.testWhileIdle}")
    private boolean testWhileIdle;

    @Value("${share.datasource.testOnBorrow}")
    private boolean testOnBorrow;

    @Value("${share.datasource.testOnReturn}")
    private boolean testOnReturn;

    @Value("${share.datasource.poolPreparedStatements}")
    private boolean poolPreparedStatements;

    @Value("${share.datasource.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Value("${share.datasource.filters}")
    private String filters;

    @Value("{share.datasource.connectionProperties}")
    private String connectionProperties;
	
    @Bean(name = "masterDataSource")
    @Primary //以此为主
    public DataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
      //configuration
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setMaxWait(maxWait);
        dataSource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        dataSource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        dataSource.setValidationQuery(validationQuery);
        dataSource.setTestWhileIdle(testWhileIdle);
        dataSource.setTestOnBorrow(testOnBorrow);
        dataSource.setTestOnReturn(testOnReturn);
        dataSource.setPoolPreparedStatements(poolPreparedStatements);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
        return dataSource;
    }
}
