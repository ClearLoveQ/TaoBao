package taobao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Cart;
import cn.tedu.store.mapper.CartMapper;

public class CartTest {
	@Test
	public void addtest() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		CartMapper cm=ac.getBean("cartMapper",CartMapper.class);
		Cart cart=new Cart();
		cart.setCount(4);
		cart.setGoodsId("2");
		cart.setUid(1);
		cm.insertCart(cart);
		System.out.println("ok");
	}
	@Test
	public void showtest() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		CartMapper cm=ac.getBean("cartMapper",CartMapper.class);
		for(Cart cart:cm.selectByUid(1)) {
			System.out.println(cart.getCount());
		}
		System.out.println("ok");
	}
}
