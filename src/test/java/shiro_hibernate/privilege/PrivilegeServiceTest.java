package shiro_hibernate.privilege;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.blake.common.ApplicationContextUtil;
import com.blake.entiyi.Privilege;
import com.blake.entiyi.Role;
import com.blake.shiro.service.PrivilegeService;
import com.blake.shiro.service.RoleService;

public class PrivilegeServiceTest {
	private static ApplicationContext ctx = ApplicationContextUtil.getApplicationContext();
	private static Session session = ctx.getBean(SessionFactory.class).openSession();
	private PrivilegeService privilegeService = ctx.getBean(PrivilegeService.class);
	private static RoleService roleService = ctx.getBean(RoleService.class);
	
	@Test
	public void isit(){
		System.out.println(privilegeService);
	}
	
	@Test
	public void save(){
		Privilege privilege = new Privilege();
		privilege.setDescription("user:edit");
		privilegeService.save(privilege);
	}
	
	@Test
	public void select(){
		
	}
	
	@Test
	public void update_(){
		Privilege privilege = privilegeService.findObjectById(1);
		Role role = roleService.findObjectById(1);
		role.getPrivileges().add(privilege);
		roleService.update(role);
	}
	
	@Test
	public void update(){
		Transaction transaction = session.beginTransaction();
		Role role = session.get(Role.class,1);
		Privilege privilege = session.get(Privilege.class,4);
		privilege.getRoles().add(role);
		session.saveOrUpdate(privilege);
		transaction.commit();
		session.close();
	}
}
