package com.brite.springbootjdbc.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseInitializer {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    CommandLineRunner loadDatabase() {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                jdbcTemplate.execute("insert into db_example.employee (name, department) "
                        + "values ('Will Smith', 'holywood.com')");

                jdbcTemplate.execute("insert into db_example.employee (name, department) "
                        + "values ('Bill Gates', 'microsoft-lab')");

            }
        };
    }
}
