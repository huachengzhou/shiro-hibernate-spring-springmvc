package shiro_hibernate.info;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.blake.base.dao.PageResult;
import com.blake.common.ApplicationContextUtil;
import com.blake.entiyi.Info;
import com.blake.entiyi.User;
import com.blake.shiro.service.InfoService;

public class InfoServiceTest {
	private static ApplicationContext ctx = ApplicationContextUtil.getApplicationContext();
	private static Session session = ctx.getBean(SessionFactory.class).openSession();
	private static InfoService infoService = ctx.getBean(InfoService.class);
	
	@Test
	public void init(){
		System.out.println(infoService);
	}
	
	@Test
	public void save(){
		Info info = new Info();
		info.setDescription("今天天气很好啊!");
		infoService.save(info);
	}
	
	@Test
	public void update(){
		Transaction transaction = session.beginTransaction();
		User user = session.get(User.class,2);
		Info info = session.get(Info.class,1);
		info.setUser(user);
		transaction.commit();
		session.close();
	}
	
	@Test
	public void select(){
		Info info = infoService.findObjectById(1);
		System.out.println(info);
	}
	
	@Test
	public void page(){
		PageResult pageResult = infoService.getPages(1, 4);
		List<Info> infos = pageResult.getItems();
		for (Info info : infos) {
			System.out.println(info.getDescription());
		}
	}
}
