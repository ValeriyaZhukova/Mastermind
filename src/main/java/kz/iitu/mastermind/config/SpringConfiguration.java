package kz.iitu.mastermind.config;

import kz.iitu.mastermind.Mastermind;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "kz.iitu.mastermind")
public class SpringConfiguration {

    @Bean
    public DataSource dataSource()
    {
        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setUrl("jdbc:postgresql://localhost:5432/Mastermind");
        driver.setUsername("postgres");
        driver.setPassword("1212");
        return driver;
    }


    @Bean
    public Mastermind getMastermind()
    {
        return new Mastermind();
    }

}
