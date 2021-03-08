package com.app.utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.app.entity.Employee;

public class HibernateUtility {

	public static SessionFactory getSession() {
		
		Properties properties=new Properties();
		properties.setProperty("hibernate.connection.driver_class","com.mysql.cj.jdbc.Driver");
		properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/hibernate-a");
		properties.setProperty("hibernate.connection.password", "root");
		properties.setProperty("hibernate.connection.username", "root");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
		Configuration configuration=new Configuration();
		configuration.addAnnotatedClass(Employee.class);
		configuration.setProperties(properties);
		
		StandardServiceRegistryBuilder registryBuilder=new StandardServiceRegistryBuilder();
		registryBuilder.applySettings(configuration.getProperties());
		StandardServiceRegistry serviceRegistry=registryBuilder.build();
		
		return configuration.buildSessionFactory(serviceRegistry);
	}
}
