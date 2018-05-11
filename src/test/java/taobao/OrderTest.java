package taobao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.OrderItem;
import cn.tedu.store.mapper.CategoryMapper;
import cn.tedu.store.mapper.OrderMapper;
import cn.tedu.store.vo.Category;

public class OrderTest {
	@Test
	public void test() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		OrderMapper cm=ac.getBean("orderMapper",OrderMapper.class);
		OrderItem orderItem=new OrderItem();
		orderItem.setUid(2);
		orderItem.setImage("/taobao/images/nowNovel/太空奇迹.png");
		cm.insertOrder(orderItem);
		System.out.println("ok");
	}
	@Test
	public void testSelect() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		OrderMapper cm=ac.getBean("orderMapper",OrderMapper.class);
		for(OrderItem o:cm.selectOrder(1)) {
			System.out.println(o.getId());
		}
		System.out.println("ok");
	}
}
