package shiro_hibernate.test;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SessionFactoryTest {
	
	@Test
	public void isit(){
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
	}
}
