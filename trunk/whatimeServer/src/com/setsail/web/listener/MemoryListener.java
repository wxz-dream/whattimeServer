package com.setsail.web.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 防止内存泄漏内存监听
 * @author 亚杰
 *
 */
public class MemoryListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
        while (drivers.hasMoreElements()) {
            Driver driver = drivers.nextElement();
            try {
                DriverManager.deregisterDriver(driver);
                System.out.println("jdbc destroyed success");
            } catch (SQLException e) {
            	System.out.println("jdbc destroyed fail");
            }
 
        }
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
	}

}
