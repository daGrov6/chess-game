package com.cdp.chessGame.application;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan(basePackages = "com.cdp.chessGame")
public class ChessGameConfiguration 
{
//	@Autowired
//	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				.setType(EmbeddedDatabaseType.DERBY)
				.addScript("database/createSchema.sql")
				.addScript("database/addData.sql")
				.build();
	}
	
	@Bean 
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabase(Database.DERBY);
		return adapter;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, 
			JpaVendorAdapter jpaVendorAdapter)
	{
		Properties props = new Properties();
		props.setProperty("hibernate.format_sql", String.valueOf(true));
		
		LocalContainerEntityManagerFactoryBean emf = 
				new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource);
		emf.setPackagesToScan("com.cdp.chessGame");
		emf.setJpaVendorAdapter(jpaVendorAdapter);
		emf.setJpaProperties(props);
		
		return emf;
	}
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf)
	{
		return new JpaTransactionManager(emf);
	}
	
	@Bean
	public BeanPostProcessor persistenceTranslation()
	{
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
