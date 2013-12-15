package ch.bfh.swos.bookapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by rovi on 13.12.13.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("ch.bfh.swos.bookapp.repository")
public class PersistenceConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:mem:bookapp;DB_CLOSE_DELAY=-1");
        ds.setUsername("bfh");
        ds.setPassword("bfh");
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setJpaVendorAdapter(this.jpaAdapter());
        emf.setPackagesToScan("ch.bfh.swos.bookapp.model");
        Properties jpaProperties = new Properties();
        jpaProperties.setProperty("eclipselink.weaving", "static");
        jpaProperties.setProperty("eclipselink.ddl-generation", "create-tables");
        jpaProperties.setProperty("eclipselink.ddl-generation.output-mode", "database");
        emf.setJpaProperties(jpaProperties);
        return emf;
    }

    @Bean
    public JpaVendorAdapter jpaAdapter() {
        EclipseLinkJpaVendorAdapter eclipseLinkJpaVendorAdapter = new EclipseLinkJpaVendorAdapter();
        eclipseLinkJpaVendorAdapter.setShowSql(true);
        eclipseLinkJpaVendorAdapter.setDatabase(Database.H2);
        return eclipseLinkJpaVendorAdapter;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory().getObject());
    }

}
