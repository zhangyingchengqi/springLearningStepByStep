package com.yc.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan(basePackages = {"com.yc"})
@EnableTransactionManagement
public class AppConfig {

    @Bean
    @Profile(value = {"test"})
    public DataSource dataSource() throws PropertyVetoException {
        DataSource ds = new ComboPooledDataSource();
        ((ComboPooledDataSource) ds).setDriverClass("com.mysql.cj.jdbc.Driver");
        //如果mysql的版本较高(>=5.5) 就需要修改url.
        ((ComboPooledDataSource) ds).setJdbcUrl("jdbc:mysql://localhost:3306/testbank?serverTimezone=GMT%2B8");
        ((ComboPooledDataSource) ds).setUser("root");
        ((ComboPooledDataSource) ds).setPassword("a");
        return ds;
    }

    @Bean  // @Bean注解的优先级高于@Component @Service...
    public TransactionManager DataSourceTransactionManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

}
