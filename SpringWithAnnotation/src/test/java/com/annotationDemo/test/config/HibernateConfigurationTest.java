package com.annotationDemo.test.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.annotationDemo.config.HibernateConfiguration;

@RunWith(MockitoJUnitRunner.class)
@Transactional
public class HibernateConfigurationTest {

	@InjectMocks
	private HibernateConfiguration hibernateConfiguration;

	@Mock
	private EntityManagerFactory entityManagerFactory;

	@Mock
	private JpaTransactionManager jpaTransactionManager;
	
	
	@Mock
	private BasicDataSource dataSource;
	
	@Mock
	private LocalContainerEntityManagerFactoryBean entityManagerFactoryBean;
	
	@Mock
	private Properties jpaProperties;

/*	@Test
	public void returnDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/userregistration");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		Assert.assertNotNull(hibernateConfiguration.dataSource());
		Assert.assertEquals("com.mysql.jdbc.Driver", dataSource.getDriverClassName());

	}
*/
	@Test
	public void shouldReturnEntityManagerFactoryBean() {

	/*	BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/userregistration");
		dataSource.setUsername("root");
		dataSource.setPassword("root");

		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.annotationDemo.model");

		Properties jpaProperties = new Properties();

		jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		jpaProperties.put("hibernate.show_sql", "true");
		jpaProperties.put("hibernate.hbm2ddl.auto", "update");
		jpaProperties.put("hibernate.format_sql", "hibernate.format_sql");

		entityManagerFactoryBean.setJpaProperties(jpaProperties);*/
		
		hibernateConfiguration.getEntityManagerFactoryBean();

		//Assert.assertNotNull(hibernateConfiguration.getEntityManagerFactoryBean());
		
		

	}

	/*@Test
	public void shouldReturnPlatformTransactionManager() {

		Assert.assertNotNull(hibernateConfiguration.getPlatformTransactionManager(entityManagerFactory));

	}*/

}
