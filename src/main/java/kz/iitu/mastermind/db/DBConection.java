package kz.iitu.mastermind.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

//@Component
public class DBConection {

    @Value("${dbconnection.dbUrl}")
    String dbUrl;
    @Value("${dbconnection.dbUsername}")
    String dbUsername;
    @Value("${dbconnection.dbPassword}")
    String dbPassword;

    DriverManagerDataSource driverManagerDataSource;

    @PostConstruct
    public void init()
    {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(dbUrl);
        driverManagerDataSource.setUsername(dbUsername);
        driverManagerDataSource.setPassword(dbPassword);
        //driverManagerDataSource.setDriverClassName(driverManagerDataSource);
        this.driverManagerDataSource = driverManagerDataSource;
    }

    public DataSource getDataSource(){
        return this.driverManagerDataSource;
    }
}
