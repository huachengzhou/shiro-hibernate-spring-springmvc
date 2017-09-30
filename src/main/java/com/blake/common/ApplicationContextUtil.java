package com.blake.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtil {
	/**
	 * @return
	 */
	public static ApplicationContext getApplicationContext(){
		return new ClassPathXmlApplicationContext("classpath:beans.xml");
	}
}
