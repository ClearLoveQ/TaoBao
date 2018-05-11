package taobao;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.store.bean.Goods;
import cn.tedu.store.mapper.MainMapper;


public class MainTest {
	@Test
	public void testMain() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		MainMapper mm=ac.getBean("mainMapper",MainMapper.class);
		List<Goods> list=mm.selectByCategoryId(1);
		for(Goods cart:list) {
			System.out.println(cart.getImage());
		}
		System.out.println("ok");
	}
	@Test
	public void testMai() {
		ApplicationContext ac=new ClassPathXmlApplicationContext("spring-dao.xml");
		MainMapper mm=ac.getBean("mainMapper",MainMapper.class);
		System.out.println(mm.selectByGoodsId("1"));
		System.out.println("ok");
	}
}
