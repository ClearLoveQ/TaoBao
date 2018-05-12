package taobao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.User;
import cn.tedu.store.mapper.PowerMapper;
import cn.tedu.store.mapper.UserMapper;
import cn.tedu.store.service.UserService;

/**
 * 用户管理测试
 * @author soft01
 *
 */
public class UserTest {
	@Test
	public void testRegister() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		UserMapper um=ac.getBean("userMapper",UserMapper.class);
		User user=new User();
		user.setUsername("腐烂");
		user.setPassword("1031861329");
		user.setPhone("18404907723");
		user.setEmail("1031861329@qq.com");
		um.registerUser(user);
		System.out.println("ok");
	}
	@Test
	public void testRegisterSer() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		UserService us=ac.getBean("userService",UserService.class);
		User user=new User();
		user.setUsername("腐烂2");
		user.setPassword("1031861329");
		user.setPhone("18404907723");
		user.setEmail("1031861328@qq.com");
		us.registerUser(user);
		System.out.println("ok");
	}
	@Test
	public void testPower() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml","spring-service.xml");
		PowerMapper pm=ac.getBean("powerMapper",PowerMapper.class);
		System.out.println(pm.backPower(1)+"权限");
	}
}
