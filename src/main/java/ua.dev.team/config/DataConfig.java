package ua.dev.team.config;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "ua.dev.team.dao")
@ComponentScan(basePackages = {"ua.dev.team.entity", "ua.dev.team.service", "ua.dev.team.dao"})
public class DataConfig {
    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/teamdev";
    private static final String DATABASE_DRIVER = "org.postgresql.Driver";
    private static final String DATABASE_USERNAME = "postgres";
    private static final String DATABASE_PASSWORD = "sin159";
    private static final String DATABASE_DIALECT = "org.hibernate.dialect.PostgreSQLDialect";
    private static final String PACKAGE_TO_SCAN = "ua.dev.team.entity";

    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(DATABASE_URL);
        basicDataSource.setDriverClassName(DATABASE_DRIVER);
        basicDataSource.setUsername(DATABASE_USERNAME);
        basicDataSource.setPassword(DATABASE_PASSWORD);
        basicDataSource.setInitialSize(5);
        basicDataSource.setMaxActive(20);
        basicDataSource.setAccessToUnderlyingConnectionAllowed(true);
        return basicDataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(false);
        adapter.setGenerateDdl(true);
        adapter.setDatabasePlatform(DATABASE_DIALECT);
        return adapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean lcemfb = new LocalContainerEntityManagerFactoryBean();
        lcemfb.setDataSource(dataSource);
        lcemfb.setJpaVendorAdapter(jpaVendorAdapter);
        lcemfb.setPackagesToScan(PACKAGE_TO_SCAN);
        return lcemfb;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }

    /**
     * Переводит (перехватывает) любые JPA или Hibernate исключения в Spring исключения.
     *
     * @return Реализация интерфейса PersistenceExceptionTranslationPostProcessor.
     */
    @Bean
    public BeanPostProcessor persistenceTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
