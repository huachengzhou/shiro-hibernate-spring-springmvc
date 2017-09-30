package shiro_hibernate.role;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.blake.common.ApplicationContextUtil;
import com.blake.entiyi.Role;
import com.blake.entiyi.User;
import com.blake.shiro.service.RoleService;

public class RoleServiceTest {
	private static ApplicationContext ctx = ApplicationContextUtil.getApplicationContext();
	private static RoleService roleService = ctx.getBean(RoleService.class);
	private static Session session = ctx.getBean(SessionFactory.class).openSession();
	
	@Test
	public void isit(){
		System.out.println(roleService);
	}
	
	@Test
	public void save(){
		Role role = new Role();
		role.setAvailable(true);
		role.setRole("teacher");
		role.setDescription("¿œ ¶");
		roleService.save(role);
	}
	
	@Test
	public void select(){
		Role role = roleService.findObjectById(3);
		System.out.println(role.getDescription());
		System.out.println(role.getPrivileges());
	}
	
	@Test
	public void update(){
		Transaction transaction = session.beginTransaction();
		Role role = session.get(Role.class,3);
		User user = session.get(User.class,3);
		role.getUsers().add(user);
		session.update(role);
		transaction.commit();
		session.close();
	}
}
