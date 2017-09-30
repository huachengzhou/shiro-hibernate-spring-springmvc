package shiro_hibernate.user;

import java.util.UUID;

import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.blake.common.ApplicationContextUtil;
import com.blake.entiyi.User;
import com.blake.shiro.service.UserService;

public class UserServiceTest {
	private static ApplicationContext ctx = ApplicationContextUtil.getApplicationContext();
	private static UserService userService = ctx.getBean(UserService.class);
	
	@Test
	public void isit(){
		System.out.println(userService);
	}
	
	@Test
	public void save (){
		User user = new User();
		user.setLocked(true);
		user.setPassword("123456");
		user.setUsername("blake");
		user.setSalt(UUID.randomUUID().toString().substring(15));
		user.setOrganizationId("ª„∑·“¯––");
		userService.save(user);
	}
	
	@Test
	public void select(){
		User user = userService.findObjectById(1);
		System.err.println(user.getOrganizationId());
		System.out.println(user.getRoles());
	}
	
	@Test
	public void login(){
		User user = userService.login("root");
		System.out.println(user);
	}
}
