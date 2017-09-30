package shiro_hibernate.ehcache;


import org.junit.Test;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.core.io.ClassPathResource;

import com.blake.entiyi.User;

public class SpringCache {
	
	@Test
	public void isit()throws Exception{
        //创建底层Cache  
        net.sf.ehcache.CacheManager ehcacheManager  
                = new net.sf.ehcache.CacheManager(new ClassPathResource("eh/ehcache.xml").getInputStream());  
      
        //创建Spring的CacheManager  
        EhCacheCacheManager cacheCacheManager = new EhCacheCacheManager();  
        //设置底层的CacheManager  
        cacheCacheManager.setCacheManager(ehcacheManager);  
      
        Long id = 1L;  
        User user =  new User();
        user.setLocked(true);
        user.setUid(2);
        user.setPassword("123456");
        user.setUsername("zhou");
      
        //根据缓存名字获取Cache  
        Cache cache = cacheCacheManager.getCache("user");  
        //往缓存写数据  
        cache.put(id, user);  
        //从缓存读数据  
        User user2 = cache.get(id,User.class);
        System.out.println("user:"+user2);
	}
}
