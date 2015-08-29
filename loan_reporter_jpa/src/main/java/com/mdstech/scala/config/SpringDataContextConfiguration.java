package com.mdstech.scala.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.jolbox.bonecp.BoneCPDataSource;

@Configuration
@PropertySource("classpath*:/META-INF/spring/application.properties")
@EnableJpaRepositories(basePackages="com.mdstech.scala.repository")
public class SpringDataContextConfiguration {

	@Resource
	private Environment environment;

	@Bean
	public DataSource dataSource() {
		BoneCPDataSource dataSource = new BoneCPDataSource();
		dataSource.setDriverClass(environment.getRequiredProperty("db.driver"));
		dataSource.setJdbcUrl(environment.getRequiredProperty("db.url"));
		dataSource.setUsername(environment.getRequiredProperty("db.username"));
		dataSource.setPassword(environment.getRequiredProperty("db.password"));
		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean()
			throws ClassNotFoundException {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPackagesToScan(new String[] {"com.mdstech.scala.domain"});
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
		Properties jpaProterties = new Properties();
		jpaProterties.setProperty("hibernate.dialect",
				environment.getRequiredProperty("hibernate.dialect"));
		jpaProterties.setProperty("hibernate.format_sql",
				environment.getRequiredProperty("hibernate.format_sql"));
		jpaProterties.setProperty("hibernate.show_sql",
				environment.getRequiredProperty("hibernate.show_sql"));
		jpaProterties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		entityManagerFactoryBean.setJpaProperties(jpaProterties);
		return entityManagerFactoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager(
			EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
