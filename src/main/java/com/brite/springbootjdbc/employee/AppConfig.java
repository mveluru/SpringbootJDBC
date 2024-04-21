package com.brite.springbootjdbc.employee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.brite.springbootjdbc")
@PropertySource("classpath:application.yml")
public class AppConfig {

    @Value("${spring.datasource.url}")
    private String URL;

    @Value("${spring.datasource.username}")
    private String USER;

    @Value("${spring.datasource.driver-class-name}")
    private String DRIVER;

    @Value("${spring.datasource.password}")
    private String PASSWORD;

    @Bean
    protected DataSource datasource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(this.getURL());
        driverManagerDataSource.setUsername(this.getUSER());
        driverManagerDataSource.setPassword(this.getPASSWORD());
        driverManagerDataSource.setDriverClassName(this.getDRIVER());
        return driverManagerDataSource;

    }

    public String getURL() {
        return URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getDRIVER() {
        return DRIVER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }
}
